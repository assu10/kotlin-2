package com.assu.study.kotlin2me.chap09

import kotlin.reflect.KClass

// T 에 대해 반공변인 인터페이스 정의
interface FieldValidator2<in T> {
    // T 를 in 위치에서만 사용 (이  메서드는 T 타입의 값은 소비함)
    fun validate(input: T): Boolean
}

object DefaultStringValidator2 : FieldValidator2<String> {
    override fun validate(input: String): Boolean = input.isNotEmpty()
}

object DefaultIntValidator2 : FieldValidator2<Int> {
    override fun validate(input: Int): Boolean = input >= 0
}

object Validators {
    // 외부에서 이 Map 에 접근할 수 없음
    private val validators = mutableMapOf<KClass<*>, FieldValidator2<*>>()

    fun <T : Any> registerValidator(
        kClass: KClass<T>,
        fieldValidator2: FieldValidator2<T>,
    ) {
        // 어떤 클래스와 검증기가 타입이 맞아 떨어지는 경우에만 그 클래스와 검증기 정보를 Map 에 넣음
        validators[kClass] = fieldValidator2
    }

    // FieldValidator2<T> 캐스팅이 안전하지 않다는 경고를 무시하게 함
    @Suppress("UNCHECKED_CAST")
    operator fun <T : Any> get(kClass: KClass<T>): FieldValidator2<T> =
        validators[kClass] as? FieldValidator2<T>
            ?: throw IllegalArgumentException("No Validator for ${kClass.simpleName}")
}

fun main() {
    Validators.registerValidator(String::class, DefaultStringValidator2)
    Validators.registerValidator(Int::class, DefaultIntValidator2)

    // 컴파일 오류
    // Type mismatch.
    // Required:String
    // Found:Int

    // Validators.registerValidator(Int::class, DefaultStringValidator2)

    println(Validators[String::class].validate("aaa")) // true
    println(Validators[String::class].validate("")) // false
    println(Validators[Int::class].validate(3)) // true

    // 컴파일 오류
    // Type mismatch.
    // Required:Int
    // Found:String

    // println(Validators[Int::class].validate("bb"))
}
