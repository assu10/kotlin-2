package com.assu.study.kotlin2me.chap09

fun test(i: Int) {
    // Int 는 Number 의 하위 타입이므로 정상적으로 컴파일됨
    val n: Number = i

    fun f(s: String) {
        println("f()~")
    }

    // 컴파일 오류
    // Int 가 String 의 하위 타입이 아니므로 컴파일되지 않음

    // f(i)
}

fun main() {
}
