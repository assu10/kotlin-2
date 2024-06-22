package com.assu.study.kotlin2me.chap04

// 비즈니스 로직
class Person2(
    val name: String,
) {
    // 비어있는 동반 객체 선언
    companion object
}

// 도우미 로직
fun Person2.Companion.fromJSON(jsonText: String): Person = Person("TEST")

fun main() {
    val result = Person2.fromJSON("aaa")
    println(result.name) // TEST
}
