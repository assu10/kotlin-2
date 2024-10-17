package com.assu.study.kotlin2me.chap09

import kotlin.Comparable

// 이 함수의 인자들은 비교가 가능해야 함
fun <T : Comparable<T>> max(
    first: T,
    second: T,
): T =
    if (first > second) {
        first
    } else {
        second
    }

fun main() {
    // bb
    println(max("aa", "bb")) //  문자열은 알파벳 순으로 비교

    // 22
    println(max("22", "11"))

    // 서로 비교할 수 없는 값이므로 컴파일 오류

    // println(max("bb", 1))
}
