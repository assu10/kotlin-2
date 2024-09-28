package com.assu.study.kotlin2me.chap07

// 피연산자는 각각 Char, Int 이고 반환 타입은 String 인 연산자 오버로딩 확장 함수
operator fun Char.times(count: Int): String = toString().repeat(count)

fun main() {
    // / aaa
    println('a' * 3)
}
