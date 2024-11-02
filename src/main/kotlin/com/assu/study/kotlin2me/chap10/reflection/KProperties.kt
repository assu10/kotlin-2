package com.assu.study.kotlin2me.chap10.reflection

fun foo(x: Int): Unit = println(x)

fun foo3(
    x: Int,
    y: Int,
    z: Int,
): Unit = println(x + y + z)

fun main() {
    // === 인자가 1개인 함수

    // KFunction1<Int, Unit> 타입 리턴
    val kFunctionFoo1 = ::foo

    // 2
    kFunctionFoo1.call(2)

    // 런타임 오류
    // Callable expects 1 arguments, but 2 were provided.

    // kFunctionFoo1.call(2, 1)

    // === 인자가 3개인 함수

    // KFunction3<Int, Int, Int, Unit> 타입 리턴
    val kFunctionFoo2 = ::foo3

    // 런타임 오류
    // Callable expects 3 arguments, but 1 were provided.

    // kFunctionFoo2.call(1)

    // 3
    kFunctionFoo2.call(1, 2, 3)
}
