package com.assu.study.kotlin2me.chap05

data class Person6(
    val name: String,
    val age: Int,
)

fun main() {
    val persons = listOf(Person6("assu", 20), Person6("silby", 2), Person6("jaehun", 22))

    // `count()` 를 이용하여 조건에 만족하는 원소 갯수 구하기
    // 2
    println(persons.count { p: Person6 -> p.age >= 20 })
}
