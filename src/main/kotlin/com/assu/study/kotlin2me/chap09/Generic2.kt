package com.assu.study.kotlin2me.chap09

// 알려진 타입 인자를 사용하여 타입 검사
fun printSum(c: Collection<Int>) {
    // 컴파일 오류
    // Cannot check for instance of erased type: List<Int>

//    if (c is List<Int>) {
//        println(c.sum())
//    }

    if (c is List<*>) {
        println("111")
        println(c.sum())
    } else {
        println("222")
    }
}

fun main() {
    printSum(listOf(1, 2)) // 222
}
