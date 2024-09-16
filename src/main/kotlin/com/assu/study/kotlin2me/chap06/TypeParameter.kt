package com.assu.study.kotlin2me.chap06

// t 가 null 이 될 수 있으므로 안전한 호출 `?.` 을 사용함
fun <T> printCode(t: T) = println(t?.hashCode())

fun <T> printCode2(t: T) = println(t.hashCode())

// 이제 T 는 null 이 될 수 없는 타입임
fun <T : Any> printCode4(t: T) = println(t.hashCode())

fun <T : Any> printCode3(t: T) = println(t?.hashCode())

fun main() {
    printCode("1") // 49

    printCode2("1") // 49

    // T 의 타입은 Any? 로 추론됨
    printCode(null) // null

    printCode2(null) // 0

    // 컴파일 오류
    // Null can not be a value of a non-null type TypeVariable(T)

    // printCode3(null)

    // 컴파일 오류
    // Null can not be a value of a non-null type TypeVariable(T)

    // printCode4(null)

    printCode3("1") // 49
    printCode4("1") // 49
}
