package com.assu.study.kotlin2me.chap07

data class Point2(
    val x: Int,
    val y: Int,
)

operator fun Point2.times(scale: Double): Point2 = Point2((x * scale).toInt(), (y * scale).toInt())

// operator fun Double.times(p: Point2): Point2 {
//    println(this)
//    return Point2(
//        (this * p.x).toInt(),
//        (this * p.y).toInt(),
//    )
// }

operator fun Double.times(p: Point2): Point2 = Point2((this * p.x).toInt(), (this * p.y).toInt())

fun main() {
    val p = Point2(10, 20)

    // Point2(x=15, y=30)
    println(p * 1.5)

    // 컴파일 오류
    // None of the following functions can be called with the arguments supplied.
    // 아래처럼 쓰려면 Double.times() 를 정의해야 함

    println(1.5 * p)
}
