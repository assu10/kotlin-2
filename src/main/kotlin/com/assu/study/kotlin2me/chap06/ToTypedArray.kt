package com.assu.study.kotlin2me.chap06

fun sum(vararg numbers: Int): Int {
    var total = 0
    for (n in numbers) {
        total += n
    }
    return total
}

fun main() {
    val strings = listOf("a", "b", "c")
    val numbers = listOf(1, 2, 3)

    // vararg 인자를 넘기기 위해 스프레드 연산자 * 사용
    println("%s %s %s".format(*strings.toTypedArray()))

    println("%s %s %s".format(*numbers.toTypedArray()))

    // 컴파일 오류
    // println("%d %d %d".format(*numbers.toIntArray()))

    // 컴파일 오류
    // Type mismatch.
    // Required: IntArray
    // Found: Array<Int>

    // sum(*numbers.toTypedArray())

    sum(*numbers.toIntArray())
}
