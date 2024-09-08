package com.assu.study.kotlin2me.chap05

data class Person5(
    val name: String,
    val age: Int,
)

fun main() {
    val persons = listOf(Person5("assu", 20), Person5("silby", 2), Person5("jaehun", 22))

    val canBeOrder20 = { p: Person5 -> p.age >= 20 }

    // all(): 모든 원소가 만족하는지 확인
    // false
    println(persons.all(canBeOrder20))

    // any(): 하나의 원소라도 만족하는지 확인
    // true
    println(persons.any(canBeOrder20))
}
