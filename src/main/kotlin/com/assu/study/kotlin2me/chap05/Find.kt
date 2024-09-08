package com.assu.study.kotlin2me.chap05

data class Person8(
    val name: String,
    val age: Int,
)

fun main() {
    val persons = listOf(Person8("assu", 20), Person8("silby", 2), Person8("jaehun", 22))
    val canBeYounger30 = { p: Person8 -> p.age <= 30 }
    val canBeYounger1 = { p: Person8 -> p.age <= 1 }

    // find() 를 사용하여 조건에 만족하는 원소가 있을 경우 첫 번째 원소 리턴
    // Person8(name=assu, age=20)
    println(persons.find(canBeYounger30))

    // findFirstOrNull() 을 사용하여 조건에 만족하는 원소가 있을 경우 첫 번째 원소 리턴
    // Person8(name=assu, age=20)
    println(persons.firstOrNull(canBeYounger30))

    // 조건에 만족하는 원소가 없을 경우
    // null
    println(persons.find(canBeYounger1))

    // null
    println(persons.firstOrNull(canBeYounger1))
}
