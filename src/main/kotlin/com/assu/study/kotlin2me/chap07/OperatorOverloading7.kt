package com.assu.study.kotlin2me.chap07

data class Point3(
    val x: Int,
    val y: Int,
)

// 단항 함수는 파라메터가 없음
operator fun Point3.unaryMinus(): Point3 = Point3(-x, -y)

fun main() {
    val p = Point3(10, 20)

    // Point3(x=-10, y=-20)
    println(-p) // p.unaryMinus()
}
