package com.assu.study.kotlin2me.chap08

data class Person3(
    val name: String,
    val age: Int,
)

val person3 = listOf(Person3("Assu", 20), Person3("Silby", 25))

fun lookForAssu(person: List<Person3>) {
    for (p in person) {
        if (p.name == "Assu") {
            println("Found!")
            return
        }
    }
    println("Not Found!")
}

fun lookForAssu1(person: List<Person3>) {
    person.forEach {
        if (it.name == "Assu") {
            println("Found!")
            return
        }
    }
    println("Not Found!")
}

fun main() {
    lookForAssu(person3) // Found!
    lookForAssu1(person3) // Found!
}
