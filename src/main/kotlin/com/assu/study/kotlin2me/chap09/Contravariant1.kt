package com.assu.study.kotlin2me.chap09

import kotlin.collections.List

fun main() {
    val anyComparator = Comparator<Any> { o1, o2 -> o1.hashCode() - o2.hashCode() }

    val strings: List<String> = listOf("bbb", "aaa", "ccc")

    // [aaa, bbb, ccc]
    println(strings.sortedWith(anyComparator))
}
