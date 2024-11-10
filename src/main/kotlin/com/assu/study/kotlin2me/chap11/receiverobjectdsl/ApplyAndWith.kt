package com.assu.study.kotlin2me.chap11.receiverobjectdsl

fun main() {
    val map = mutableMapOf(1 to "one")

    map.apply { this[2] = "two" }

    with(map) { this[3] = "three" }

    // {1=one, 2=two, 3=three}
    println(map)
}
