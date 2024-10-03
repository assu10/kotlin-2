package com.assu.study.kotlin2me.chap07

class Person2 {
    private val attributes = hashMapOf<String, String>()

    fun setAttribute(
        attrName: String,
        value: String,
    ) {
        attributes[attrName] = value
    }

    // 위임 프로퍼티로 Map 을 사용
    val name: String by attributes
}

fun main() {
    val p = Person2()
    val data = mapOf("name" to "Assu", "addr" to "Seoul")

    for ((attrName, value) in data) {
        p.setAttribute(attrName, value)
    }

    println(p.name) // Assu
}
