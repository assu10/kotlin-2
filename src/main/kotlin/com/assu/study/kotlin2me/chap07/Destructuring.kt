package com.assu.study.kotlin2me.chap07

data class Point7(
    val x: Int,
    val y: Int,
)

fun main() {
    val p = Point7(10, 20)

    // x, y 변수를 선언한 다음 p 의 여러 컴포넌트로 초기화함
    val (x, y) = p

    println(x) // 10
    println(y) // 20
}
