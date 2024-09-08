package com.assu.study.kotlin2me.chap05

data class Person7(
    val name: String,
    val age: Int,
)

fun main() {
    val persons = listOf(Person7("assu", 20), Person7("silby", 2), Person7("jaehun", 22))
    val canBeOrder20 = { p: Person7 -> p.age >= 20 }

    // `count()` 대신 size 를 사용하는 비효율적인 코드
    // 2
    println(persons.filter(canBeOrder20).size)

    // `count()` 를 이용한 효율적인 코드
    // 2
    println(persons.count(canBeOrder20))
}
