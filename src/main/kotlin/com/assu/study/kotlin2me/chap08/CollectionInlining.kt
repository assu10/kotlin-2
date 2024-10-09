package com.assu.study.kotlin2me.chap08

data class Person1(
    val name: String,
    val age: Int,
)

fun main() {
    val person1 = listOf(Person1("Assu", 20), Person1("Silby", 5))

    // 람다를 사용하여 컬렉션 필터링
    // [Person1(name=Silby, age=5)]
    println(person1.filter { it.age < 15 })

    // 람다를 사용하지 않고 컬렉션 필터링
    val result = mutableListOf<Person1>()
    for (person in person1) {
        if (person.age < 15) {
            result.add(person)
        }
    }
    // [Person1(name=Silby, age=5)]
    println(result)
}
