package com.assu.study.kotlin2me.chap10.reflection

fun sum(
    x: Int,
    y: Int,
) = x + y

fun main() {
    // KFunction<Int, Int, Int> 타입 리턴
    val kFunction = ::sum

    // 10
    println(kFunction.invoke(1, 2) + kFunction(3, 4))

    // 컴파일 오류
    // No value passed for parameter 'y'

    // kFunction(1)
}
