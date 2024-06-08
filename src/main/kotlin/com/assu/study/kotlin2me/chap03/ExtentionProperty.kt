package com.assu.study.kotlin2me.chap03

var StringBuilder.lastChar: Char
    get() = get(length - 1) // 프로퍼티 게터
    set(value: Char) {
        this.setCharAt(length - 1, value) // 프로퍼티 세터
    }

fun main() {
    var sb = StringBuilder("Hello?")
    sb.lastChar = '!'
    println(sb)
}
