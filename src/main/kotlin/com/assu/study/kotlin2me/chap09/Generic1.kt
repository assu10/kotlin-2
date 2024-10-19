package com.assu.study.kotlin2me.chap09

// 제네릭 타입으로 타입 캐스팅
fun printSum(c: Collection<*>) {
    // Unchecked cast: Collection<*> to List<Int> 경고뜸
    // 컴파일은 됨, 즉 캐스팅은 됨
    val intList = c as? List<Int> ?: throw IllegalArgumentException("List is expected")

    // 컴파일 오류
    // sum() 이 호출되지 않음
    // println(intList.sum())
}

fun main() {
    // printSum(listOf(1, 2))
    printSum(listOf("a", "b"))
}
