package com.assu.study.kotlin2me.chap06

fun main() {
    val letters = Array<String>(26) { i -> ('a' + i).toString() }

    letters.forEachIndexed { index, s -> println("$index is $s") }
}
