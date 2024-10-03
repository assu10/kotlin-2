package com.assu.study.kotlin2me.chap07

class Person1 {
    // 추가 정보
    private val attributes = hashMapOf<String, String>()

    fun setAttribute(
        attrName: String,
        value: String,
    ) {
        attributes[attrName] = value
    }

    // 필수 정보
    val name: String
        get() = attributes["name"]!! // 수동으로 Map 에서 꺼냄
}

fun main() {
    val p = Person1()
    val data = mapOf("name" to "Assu", "addr" to "Seoul")

    for ((attrName, value) in data) {
        p.setAttribute(attrName, value)
    }

    println(p.name) // Assu
}
