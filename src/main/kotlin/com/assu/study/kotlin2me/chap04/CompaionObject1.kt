package com.assu.study.kotlin2me.chap04

interface JSONFactory<T> {
    fun fromJSON(jsonText: String): T
}

class Person(
    val name: String,
) {
    // 동반 객체가 인터페이스 구현
    companion object : JSONFactory<Person> {
        override fun fromJSON(jsonText: String): Person = Person("TEST")
    }
}

fun <T> loadFromJSON(factory: JSONFactory<T>) = factory

fun main() {
    // 동반 객체의 인스턴스를 함수에 넘김
    // 동반 객체가 구현한 JSONFactory 의 인스턴스를 넘길 때 Person 의 인스턴스가 아닌 Person 클래스 이름을 넘김
    loadFromJSON(Person)

    val result = Person.fromJSON("aaa")
    println(result.name) // TEST
}
