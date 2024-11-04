package ru.yole.jkid.deserialization

import ru.yole.jkid.DeserializeInterface
import ru.yole.jkid.JsonName
import ru.yole.jkid.ValueSerializer
import ru.yole.jkid.findAnnotation
import ru.yole.jkid.serialization.getSerializer
import ru.yole.jkid.serializerForType
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KParameter
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.jvm.javaType

class ClassInfoCache {
    private val cacheData = mutableMapOf<KClass<*>, ClassInfo<*>>()

    @Suppress("UNCHECKED_CAST")
    operator fun <T : Any> get(cls: KClass<T>): ClassInfo<T> =
        // cls 에 대한 항목이 cacheData 맵에 있으면 그 항목을 반환
        // 그런 항목이 없다면 전달받은 람다를 호출하여 key 에 대한 값을 계산한 후 그 결과값을 맵에 저장한 다음 반환함
        cacheData.getOrPut(cls) { ClassInfo(cls) } as ClassInfo<T>
}

class ClassInfo<T : Any>(
    cls: KClass<T>,
) {
    private val className = cls.qualifiedName
    private val constructor: KFunction<T> =
        cls.primaryConstructor
            ?: throw JKidException("Class ${cls.qualifiedName} doesn't have a primary constructor")

    // JSON 파일의 각 key 에 해당하는 파라메터 저장
    private val jsonNameToParamMap = hashMapOf<String, KParameter>()

    // 각 파라메터에 대한 직렬화기 저장
    private val paramToSerializerMap = hashMapOf<KParameter, ValueSerializer<out Any?>>()

    // @DeserializeInterface 애너테이션 인자로 지정한 클래스 저장
    private val jsonNameToDeserializeClassMap = hashMapOf<String, Class<out Any>?>()

    // 초기화 시 각 생성자 파라메터에 해당하는 프로퍼티를 찾아서 애너테이션을 가져옴
    init {
        constructor.parameters.forEach { cacheDataForParameter(cls, it) }
    }

    private fun cacheDataForParameter(
        cls: KClass<*>,
        param: KParameter,
    ) {
        val paramName =
            param.name
                ?: throw JKidException("Class $className has constructor parameter without name")

        val property = cls.declaredMemberProperties.find { it.name == paramName } ?: return
        val name = property.findAnnotation<JsonName>()?.name ?: paramName
        jsonNameToParamMap[name] = param

        val deserializeClass = property.findAnnotation<DeserializeInterface>()?.targetClass?.java
        jsonNameToDeserializeClassMap[name] = deserializeClass

        val valueSerializer =
            property.getSerializer()
                ?: serializerForType(param.type.javaType)
                ?: return
        paramToSerializerMap[param] = valueSerializer
    }

    fun getConstructorParameter(propertyName: String): KParameter =
        jsonNameToParamMap[propertyName]
            ?: throw JKidException("Constructor parameter $propertyName is not found for class $className")

    fun getDeserializeClass(propertyName: String) = jsonNameToDeserializeClassMap[propertyName]

    fun deserializeConstructorArgument(
        param: KParameter,
        value: Any?,
    ): Any? {
        val serializer = paramToSerializerMap[param]
        if (serializer != null) return serializer.fromJsonValue(value)

        validateArgumentType(param, value)
        return value
    }

    private fun validateArgumentType(
        param: KParameter,
        value: Any?,
    ) {
        if (value == null && !param.type.isMarkedNullable) {
            throw JKidException("Received null value for non-null parameter ${param.name}")
        }
        if (value != null && value.javaClass != param.type.javaType) {
            throw JKidException(
                "Type mismatch for parameter ${param.name}: " +
                    "expected ${param.type.javaType}, found ${value.javaClass}",
            )
        }
    }

    fun createInstance(arguments: Map<KParameter, Any?>): T {
        ensureAllParametersPresent(arguments)
        return constructor.callBy(arguments)
    }

    // 생성자에 필요한 필수 파라메터가 맵에 모두 있는지 검증
    // 리플렉션 캐시를 사용하면 이 함수에서 수행하는 과정(역직렬화를 제어하는 애너테이션을 찾는 과정) 을 JSON 데이터에서 발견한
    // 모든 프로퍼티에 대해 반복할 필요없이 프로퍼티 이름별로 단 한번만 수행 가능
    private fun ensureAllParametersPresent(arguments: Map<KParameter, Any?>) {
        for (param in constructor.parameters) {
            // 파라메터에 디폴트 값이 있으면 param.isOptional 이 true 이므로 그런 파라메터에 대한 인자가 인자 맵에 없어도 문제없음
            // 파라메터가 null 이 될 수 있는 값이라면 type.isMarkedNullable 이 true 이므로 디폴트 파라메터 값으로 null 을 사용함
            // 이 두 가지 경우가 모두 아니라면 예외 발생
            if (arguments[param] == null && !param.isOptional && !param.type.isMarkedNullable) {
                throw JKidException("Missing value for parameter ${param.name}")
            }
        }
    }
}

class JKidException(
    message: String,
) : Exception(message)
