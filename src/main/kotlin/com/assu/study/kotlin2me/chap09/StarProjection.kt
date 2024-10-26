package com.assu.study.kotlin2me.chap09

import kotlin.random.Random

fun main() {
    val list: MutableList<Any?> = mutableListOf('a', 1, "bbb")
    val chars = mutableListOf('a', 'b', 'c')

    // MutableList<*> 과 MutableList<Any?> 는 다름
    val unknownElements: MutableList<*> =
        if (Random.nextBoolean()) { // list 와 chars 중 랜덤으로 할당
            list
        } else {
            chars
        }

    // 컴파일 오류
    // unknownElements.add(3)

    // bb 는 Any? 타입임
    // 원소를 가져와도 안전함
    val bb = unknownElements.first()

    // a
    println(bb)
}
