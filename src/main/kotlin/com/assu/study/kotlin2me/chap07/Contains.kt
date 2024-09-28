package com.assu.study.kotlin2me.chap07

data class Point6(
    val x: Int,
    val y: Int,
)

data class Rectangle(
    val upperLeft: Point6,
    val lowerRight: Point6,
)

operator fun Rectangle.contains(p: Point6): Boolean =
    // 범위를 만들고 x,y 좌표가 그 범위 안에 있는지 검사
    p.x in upperLeft.x until lowerRight.x &&
        p.y in upperLeft.y until lowerRight.y

fun main() {
    val rect = Rectangle(Point6(10, 20), Point6(50, 50))

    println(Point6(20, 30) in rect) // true
    println(Point6(5, 5) in rect) // false
}
