package com.assu.study.kotlin2me.chap06

fun main() {
    val i = 1

    // 컴파일 오류
    // Type mismatch.
    // Required: Long
    // Found: Int

    // val l: Long = i

    // 변환 메서드 호출
    val l: Long = i.toLong()

    val x = 1
    val list = listOf(1L, 2L)

    // 컴파일 오류
    // println(x in list)

    // 타입을 명시적으로 변환하여 같은 타입의 값으로 만든 후 비교
    println(x.toLong() in list) // true

    println("1".toInt()) // 1

    // 런타임 오류
    // java.lang.NumberFormatException: For input string: "1L"
    // println("1L".toLong())
}
