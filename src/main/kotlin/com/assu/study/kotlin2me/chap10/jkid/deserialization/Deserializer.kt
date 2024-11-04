package ru.yole.jkid.deserialization

import ru.yole.jkid.asJavaClass
import ru.yole.jkid.isPrimitiveOrString
import ru.yole.jkid.serializerForBasicType
import java.io.Reader
import java.io.StringReader
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import kotlin.reflect.KClass
import kotlin.reflect.KParameter
import kotlin.reflect.jvm.javaType

inline fun <reified T : Any> deserialize(json: String): T = deserialize(StringReader(json))

inline fun <reified T : Any> deserialize(json: Reader): T = deserialize(json, T::class)

fun <T : Any> deserialize(
    json: Reader,
    targetClass: KClass<T>,
): T {
    // 파싱을 시작하기 위해 직렬화할 객체의 프로퍼티를 담을 ObjectSeed 하나 생성
    val seed = ObjectSeed(targetClass, ClassInfoCache())

    // 파서를 호출하면서 입력 스트림 reader 인 json 과 seed 를 인자로 전달
    Parser(json, seed).parse()

    // 결과 객체 생성
    return seed.spawn()
}

interface JsonObject {
    fun setSimpleProperty(
        propertyName: String,
        value: Any?,
    )

    fun createObject(propertyName: String): JsonObject

    fun createArray(propertyName: String): JsonObject
}

interface Seed : JsonObject {
    val classInfoCache: ClassInfoCache

    // 객체 생성 과정이 끝난 후 결과 인스턴스를 얻음
    fun spawn(): Any?

    fun createCompositeProperty(
        propertyName: String,
        isList: Boolean,
    ): JsonObject

    override fun createObject(propertyName: String) = createCompositeProperty(propertyName, false)

    override fun createArray(propertyName: String) = createCompositeProperty(propertyName, true)
}

// 파타메터의 타입을 분석하여 적절히 ObjectSeed, ObjectListSeed, ValueListSeed 중 하나 생성
fun Seed.createSeedForType(
    paramType: Type,
    isList: Boolean,
): Seed {
    val paramClass = paramType.asJavaClass()

    if (List::class.java.isAssignableFrom(paramClass)) {
        if (!isList) throw JKidException("An array expected, not a composite object")
        val parameterizedType =
            paramType as? ParameterizedType
                ?: throw UnsupportedOperationException("Unsupported parameter type $this")

        val elementType = parameterizedType.actualTypeArguments.single()
        if (elementType.isPrimitiveOrString()) {
            return ValueListSeed(elementType, classInfoCache)
        }
        return ObjectListSeed(elementType, classInfoCache)
    }
    if (isList) throw JKidException("Object of the type ${paramType.typeName} expected, not an array")
    return ObjectSeed(paramClass.kotlin, classInfoCache)
}

// 지금 만들고 있는 객체의 상태 저장
class ObjectSeed<out T : Any>(
    targetClass: KClass<T>, // 결과 클래스의 참조
    // 결과 클래스 안의 프로퍼티에 대한 정보를 저장하는 캐시
    // 나중에 이 캐시 정보를 사용해서 클래스의 인스턴스 생성
    override val classInfoCache: ClassInfoCache,
) : Seed {
    // targetClass 의 인스턴스를 만들 때 필요한 정보 캐싱
    private val classInfo: ClassInfo<T> = classInfoCache[targetClass]

    // 생성자 파라메터와 값을 연결해주는 맵 생성
    // 이를 위해 아래의 변경 가능한 맵 사용

    // 간단한 값 프로퍼티 저장
    private val valueArguments = mutableMapOf<KParameter, Any?>()

    // 복합 프로퍼티 저장
    private val seedArguments = mutableMapOf<KParameter, Seed>()

    // 생성자 파라메터와 그 값을 연결하는 맵 생성
    private val arguments: Map<KParameter, Any?>
        get() = valueArguments + seedArguments.mapValues { it.value.spawn() }

    // 결과를 만들여서 valueArguments 맵에 새 인자 추가
    override fun setSimpleProperty(
        propertyName: String,
        value: Any?,
    ) {
        val param = classInfo.getConstructorParameter(propertyName)

        // 생성자 파라메터 값이 간단한 경우 그 값을 기록
        valueArguments[param] = classInfo.deserializeConstructorArgument(param, value)
    }

    // seedArguments 맵에 새 인자 추가
    override fun createCompositeProperty(
        propertyName: String,
        isList: Boolean,
    ): Seed {
        val param = classInfo.getConstructorParameter(propertyName)

        // 프로퍼티에 대한 DeserializeInterface 애너테이션이 있다면 그 값을 가져옴
        val deserializeAs = classInfo.getDeserializeClass(propertyName)

        // 파라메터 타입에 따라 ObjectSeed, CollectionSeed 생성 (1)
        val seed =
            createSeedForType(
                // 파타메터의 타입을 분석하여 적절히 ObjectSeed, ObjectListSeed, ValueListSeed 중 하나 새엇ㅇ
                deserializeAs ?: param.type.javaType,
                isList,
            )

        // (1) 에서 만든 Seed 객체를 seedArguments 맵에 기록
        return seed.apply { seedArguments[param] = this }
    }

    // 인자 맵을 넘겨서 targetClass 타입의 인스턴스 생성
    // 내부에 중첩된 모든 Seed 의 spawn() 을 재귀적으로 호출하여 내부 객체 계층 구조 생성
    // 재귀적으로 복합 (Seed) 인자 만드는 과정: arguments 의 커스텀 getter 안에서 mapValues() 를 사용하여 seedArguments 각 원소에 대해 spawn() 호출
    override fun spawn(): T = classInfo.createInstance(arguments)
}

class ObjectListSeed(
    val elementType: Type,
    override val classInfoCache: ClassInfoCache,
) : Seed {
    private val elements = mutableListOf<Seed>()

    override fun setSimpleProperty(
        propertyName: String,
        value: Any?,
    ): Unit = throw JKidException("Found primitive value in collection of object types")

    override fun createCompositeProperty(
        propertyName: String,
        isList: Boolean,
    ) = createSeedForType(elementType, isList).apply { elements.add(this) }

    override fun spawn(): List<*> = elements.map { it.spawn() }
}

class ValueListSeed(
    elementType: Type,
    override val classInfoCache: ClassInfoCache,
) : Seed {
    private val elements = mutableListOf<Any?>()
    private val serializerForType = serializerForBasicType(elementType)

    override fun setSimpleProperty(
        propertyName: String,
        value: Any?,
    ) {
        elements.add(serializerForType.fromJsonValue(value))
    }

    override fun createCompositeProperty(
        propertyName: String,
        isList: Boolean,
    ): Seed = throw JKidException("Found object value in collection of primitive types")

    override fun spawn() = elements
}
