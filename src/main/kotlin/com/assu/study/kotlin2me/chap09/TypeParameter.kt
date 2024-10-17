package com.assu.study.kotlin2me.chap09

// Number 를 타입 파라메터 상한으로 정함
fun <T : Number> oneHalf(value: T): Double {
    // Number 클래스에 정의된 메서드 호출
    return value.toDouble() / 2.0
}

fun main() {
    println(oneHalf(3)) // 1.5
}
