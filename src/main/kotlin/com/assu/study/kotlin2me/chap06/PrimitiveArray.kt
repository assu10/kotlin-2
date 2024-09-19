package com.assu.study.kotlin2me.chap06

fun main() {
    // 각 배열 타입의 생성자는 size 인자를 받아서 해당 primitive 타입의 디폴트 값 (보통은 0) 으로 초기화된 size 크기의 배열 반환
    val fiveZeros: IntArray = IntArray(5)

    // 팩토리 함수 intArrayOf() 사용
    val fiveZeros2: IntArray = intArrayOf(0, 0, 0, 0, 0)

    // 크기와 람다를 인자로 받는 생성자를 사용
    val fiveZeros3: IntArray = IntArray(5) { i -> i + 1 }

    println(fiveZeros) // [I@53d8d10a
    println(fiveZeros2) // [I@e9e54c2
    println(fiveZeros3) // [I@65ab7765

    println(fiveZeros.joinToString()) // 0, 0, 0, 0, 0
    println(fiveZeros2.joinToString()) // 0, 0, 0, 0, 0
    println(fiveZeros3.joinToString()) // 1, 2, 3, 4, 5
}
