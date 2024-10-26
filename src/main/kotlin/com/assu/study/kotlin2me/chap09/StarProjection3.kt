package com.assu.study.kotlin2me.chap09

import kotlin.reflect.KClass

// T 에 대해 반공변인 인터페이스 정의
interface FieldValidator<in T> {
    // T 를 in 위치에서만 사용 (이  메서드는 T 타입의 값은 소비함)
    fun validate(input: T): Boolean
}

object DefaultStringValidator : FieldValidator<String> {
    override fun validate(input: String): Boolean = input.isNotEmpty()
}

object DefaultIntValidator : FieldValidator<Int> {
    override fun validate(input: Int): Boolean = input >= 0
}

fun main() {
    val validators = mutableMapOf<KClass<*>, FieldValidator<*>>()
    validators[String::class] = DefaultStringValidator
    validators[Int::class] = DefaultIntValidator

    // 컴파일 오류
    // validators[String::class]!!.validate("Abc")

    // 강제 캐스팅
    // Warning- Unchecked cast: FieldValidator<*>? to FieldValidator<String>
    val stringValidator = validators[String::class] as FieldValidator<String>

    println(stringValidator.validate("aa")) // true
    println(stringValidator.validate("")) // false

    // 검증기를 잘못 가져왔지만 컴파일과 타입 캐스팅 시엔 아무런 문제가 발생하지 않음
    val stringValidator2 = validators[Int::class] as FieldValidator<String>

    // 런타임 오류
    // class java.lang.String cannot be cast to class java.lang.Number
    println(stringValidator2.validate(""))
}
