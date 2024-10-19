package com.assu.study.kotlin2me.chap09

// 컴파일 오류
// Cannot check for instance of erased type: T
// fun <T> isA(value: Any) = value is T

// inline 과 reified 사용
inline fun <reified T> isB(value: Any) = value is T

fun main() {
    println(isB<String>("ab")) // true
    println(isB<String>(123)) // false
}
