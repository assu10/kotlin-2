package com.assu.study.kotlin2me.chap09

import kotlin.collections.List

// 모든 리스트를 인자로 받을 수 있음
fun printFirst(list: List<*>) {
    if (list.isNotEmpty()) { // 제네릭 타입 파라메터를 사용하지 않음
        // tmp 는 Anu? 타입이지만 여기서는 그 타입만으로 충분함
        val tmp = list.first()
        println(tmp)
    }
}

fun <T> printFirst2(list: List<T>) {
    if (list.isNotEmpty()) {
        // tmp 는 T 타입
        val tmp = list.first()
        println(tmp)
    }
}

fun main() {
    // aaa
    printFirst(listOf("aaa", 222))

    // 222
    printFirst2(listOf(222, "aaa"))
}
