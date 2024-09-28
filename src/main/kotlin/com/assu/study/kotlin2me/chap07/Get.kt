package com.assu.study.kotlin2me.chap07

data class Point4(
    val x: Int,
    val y: Int,
)

// get() 연산자 함수 정의
operator fun Point4.get(index: Int): Int =
    // 주어진 인덱스에 해당하는 좌표 찾음
    when (index) {
        0 -> x
        1 -> y
        else ->
            throw IndexOutOfBoundsException("Invalid coordinate $index")
    }

fun main() {
    val p = Point4(10, 20)

    println(p[0]) // 10, p.get(0)
}
