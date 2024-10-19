package com.assu.study.kotlin2me.chap09

fun main() {
    val items = listOf("one", 2, "three")

    // [one, three]
    println(items.filterIsInstance<String>())
}
