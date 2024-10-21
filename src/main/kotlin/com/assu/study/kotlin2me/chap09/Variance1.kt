package com.assu.study.kotlin2me.chap09

fun printContents(list: List<Any>) {
    println(list)
}

fun addAnswer(list: MutableList<Any>) {
    list.add(1)
}

fun main() {
    // 컴파일 오류
    // Type mismatch.
    // Required: com. assu. study. kotlin2me. chap09.List<Any>
    // Found:kotlin. collections. List<String>

    // printContents(listOf("a", "b"))

    // MutableList<String> 타입의 변수 선언
    val strings = mutableListOf("a", "b")

    // 컴파일 오류
    // Type mismatch.
    // Required: MutableList<Any>
    // Found: MutableList<String>

    // addAnswer(strings)
}
