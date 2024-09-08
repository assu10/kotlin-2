package com.assu.study.kotlin2me.chap05

fun main() {
    // 0~100 까지의 자연수의 합
    val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }

    // 5050
    println(numbersTo100.sum())
}
