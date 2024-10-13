package com.assu.study.kotlin2me.chap09

// 제네릭 확장 프로퍼티
// 모든 리스트 타입에 이 제네릭 확장 프로퍼티 사용 가능
val <T> List<T>.pre: T
    get() = this[size - 2]

// 컴파일 오류
// Type parameter of a property must be used in its receiver type

// 확장 프로퍼티가 아닌 일반 프로터티는 제네릭하게 만들 수 없음

// val <T> x: T = TODO()

fun main() {
    val authors = listOf("Assu", "Silby")
    val readers = mutableListOf<String>()

    readers.add("Jaehoon")
    readers.add("Assu")

    val result = readers.filter { it !in authors }

    // [Jaehoon]
    println(result)

    // 제네릭 확장 프로퍼티 사용
    // 이 호출에서 타입 파라메터 T 는 int 로 추론됨
    println(listOf(1, 2, 3).pre)
}
