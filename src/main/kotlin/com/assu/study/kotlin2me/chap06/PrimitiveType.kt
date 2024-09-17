package com.assu.study.kotlin2me.chap06

fun main() {
    val i: Int = 1
    val list: List<Int> = listOf(1, 2, 3)

    val progress: Int = 170
    val percentage = progress.coerceIn(0, 100)
    println(percentage) // 100
}
