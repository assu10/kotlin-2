package com.assu.study.kotlin2me.chap08

// 함수 타입인 파라메터를 선언
fun twoAndThree(operation: (Int, Int) -> Int) {
    // 함수 타입인 파라메터를 호출
    val result = operation(2, 3)
    println("result: $result")
}

fun main() {
    // result: 5
    twoAndThree { a, b -> a + b }

    // result: 6
    twoAndThree { a, b -> a * b }
}
