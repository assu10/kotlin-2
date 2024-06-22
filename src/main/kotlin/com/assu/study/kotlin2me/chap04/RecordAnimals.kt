package com.assu.study.kotlin2me.chap04

// 다른 파일에서 접근 불가
private var index = 0

// 다른 파일에서 접근 불가
private class Animal(
    val name: String,
)

// 다른 파일에서 접근 불가
private fun recordAnimal(animal: Animal) {
    println("Animal #$index: ${animal.name}~")
    index++
}

fun recordAnimals() {
    recordAnimal(Animal("AA"))
    recordAnimal(Animal("BB"))
}

fun recordAnimalsCount() {
    println("$index here~")
}

fun main() {
    // Animal #0: AA~
    // Animal #1: BB~
    recordAnimals()

    // 2 here~
    recordAnimalsCount()
}
