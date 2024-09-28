package com.assu.study.kotlin2me.chap07

data class Point(
    val x: Int,
    val y: Int,
) {
    // 연산자를 멤버 함수로 오버로딩
//    operator fun plus(other: Point) = Point(x + other.x, y + other.y)
}

// 연산자를 확장 함수로 오버로딩
operator fun Point.minus(other: Point) = Point(x - other.x, y - other.y)

operator fun Point.plus(other: Point) = Point(x + other.x, y + other.y)

fun main() {
    val p1 = Point(10, 20)
    val p2 = Point(20, 40)

    // Point(x=30, y=60)
    println(p1 + p2) // p1.plus(p2)

    var p3 = Point(1, 2)
    p3 += Point(3, 4) // p3 = p3 + Point(3,4)
    println(p3)

    // Point(x=-10, y=-20)
    println(p1 - p2)
}
