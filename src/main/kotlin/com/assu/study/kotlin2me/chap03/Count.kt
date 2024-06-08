package com.assu.study.kotlin2me.chap03

var opCount = 0 // 최상위 프로퍼티

// const 변경자 추가 시 컴파일하면 public static final 로 컴파일됨
const val UNIX_LINE_SEPARATOR = "\n"

fun performOperation() {
    opCount++ // 최상위 프로퍼티 값 변경
}

fun readOperation() {
    println("opCount: $opCount") // 최상위 프로퍼티 값 읽음
}

fun main() {
    performOperation()
    performOperation()
    readOperation() // opCount: 2
    println(UNIX_LINE_SEPARATOR)
}
