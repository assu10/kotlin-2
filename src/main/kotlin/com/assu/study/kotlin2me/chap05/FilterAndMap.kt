package com.assu.study.kotlin2me.chap05

data class Person3(
    val name: String,
    val age: Int,
)

fun main() {
    val list = listOf(1, 2, 3, 4)

    // filter() 사용
    // 짝수만 남음
    val even = list.filter { it % 2 == 0 }

    // [2,4]
    println(even)

    // map() 을 이용하여 각 원소에 곱하기 2
    val multiple = list.map { it * 2 }

    // [2,4,6,8]
    println(multiple)

    // map() 을 이용하여 이름만 출력
    val persons = listOf(Person3("assu", 20), Person3("silby", 2))
    val names = persons.map { it.name }

    // [assu, silby]
    println(names)

    // filter() 와 map() 을 이용하여 10살 이상인 사람의 이름만 출력
    val tens = persons.filter { it.age >= 10 }.map(Person3::name)

    // [assu]
    println(tens)
}
