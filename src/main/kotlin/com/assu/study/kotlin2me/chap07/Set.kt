package com.assu.study.kotlin2me.chap07

// 생성자 파라메터가 var (= 가변 클래스)
data class Point5(
    var x: Int,
    var y: Int,
)

operator fun Point5.set(
    index: Int,
    value: Int,
) {
    when (index) {
        0 -> x = value
        1 -> y = value
        else -> throw IndexOutOfBoundsException()
    }
}

fun main() {
    val p = Point5(10, 20)
    p[1] = 30 // p.set(1, 20)

    // Point5(x=10, y=30)
    println(p)
}
