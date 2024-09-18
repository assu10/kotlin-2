package com.assu.study.kotlin2me.chap06

// null 인 원소 걸러내기
fun addValidNumbers(numbers: List<Int?>): List<Int> {
    val validNumbers = numbers.filterNotNull()
    return validNumbers
}

fun main() {
    val numbers = addValidNumbers(listOf(1, 2, null, 5))

    // [1, 2, 5]
    println(numbers)
}
