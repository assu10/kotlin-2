package com.assu.study.kotlin2me.chap05

data class Person9(
    val name: String,
    val age: Int,
)

fun main() {
    val persons = listOf(Person9("assu", 20), Person9("silby", 2), Person9("ajaehun", 20))

    // 나이별로 구분
    // {20=[Person9(name=assu, age=20), Person9(name=ajaehun, age=20)], 2=[Person9(name=silby, age=2)]}
    println(persons.groupBy { it.age })

    // 멤버 참조인 :: 를 이용하여 첫 글자에 따라 분류
    val list = listOf("a", "ab", "b")

    // {a=[a, ab], b=[b]}
    println(list.groupBy(String::first))
}
