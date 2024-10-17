package com.assu.study.kotlin2me.chap09

fun <T> ensureTrailingPeriod(seq: T)
        where T : CharSequence, T : Appendable { // 타입 파라메터 제약 목록
    if (!seq.endsWith('.')) { // CharSequence 인터페이스의 확장 함수 호출
        seq.append('.') // Appendable 인터페이스의 메서드 호출
    }
}

fun main() {
    val hello = StringBuilder("Hello world")
    ensureTrailingPeriod(hello)

    // Hello world.
    println(hello)
}
