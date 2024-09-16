package com.assu.study.kotlin2me.chap06

// uppercase() 의 수신 객체 person.name 이 null 이면 예외 발생
fun yellAt(person: Person5) = println(person.name.uppercase())

fun yellAtSafe(person: Person5) = println((person.name ?: "Anyone").uppercase())

fun main() {
    yellAt(Person5(null))
    yellAtSafe(Person5(null))
}
