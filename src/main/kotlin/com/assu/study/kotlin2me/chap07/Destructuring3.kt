package com.assu.study.kotlin2me.chap07

fun main() {
    val x = listOf(1, 2)

    // 런타임 에러
    // java.lang.ArrayIndexOutOfBoundsException: Index 2 out of bounds for length 2

    // val (a, b, c, d, e) = x

    // 컴파일 에러
    // Destructuring declaration initializer of type List<Int> must have a 'component6()' function

    // val (a, b, c, d, e, f) = x
}
