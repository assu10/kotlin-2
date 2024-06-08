package com.assu.study.kotlin2me.chap03

fun main() {
    val str = "12.456-6.A"

    // 정규식을 이용한 문자열 분리
    val regex = "\\.|-".toRegex()

    // [12, 456, 6, A]
    println(str.split(regex))

    // 구분 문자열을 이용한 문자열 분리
    // [12, 456, 6, A]
    println(str.split(".", "-")) // 여러 개의 구분 문자열 지정
}
