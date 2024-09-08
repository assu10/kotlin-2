package com.assu.study.kotlin2me.chap05

data class Person4(
    val name: String,
    val age: Int,
)

fun main() {
    val persons = listOf(Person4("assu", 20), Person4("silby", 2))

    // 목록에서 가장 나이가 많은 사람의 정보 구하기

    // 아래 방법은 최대값을 구하는 작업을 계속 반복함 (100 명이 있다면 100번의 최대값 연산 수행)
    val order = persons.filter { it.age == persons.maxBy(Person4::age).age }

    // [Person4(name=assu, age=20)]
    println(order)

    // 최대값을 한번만 계산해서 나이가 가장 많은 사람의 정보 구하기
    val maxAge = persons.maxBy(Person4::age).age
    var order2 = persons.filter { it.age == maxAge }

    // [Person4(name=assu, age=20)]
    println(order2)

    // mapValues() 을 이용하여 value 를 대문자로 변환
    val numbers = mapOf(0 to "zero", 1 to "one")

    // {0=ZERO, 1=ONE}
    println(numbers.mapValues { it.value.uppercase() })
}
