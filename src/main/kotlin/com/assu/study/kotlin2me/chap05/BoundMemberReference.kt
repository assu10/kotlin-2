package com.assu.study.kotlin2me.chap05

import kotlin.io.println

class Person2(
    val name: String, // 읽기 전용 프로퍼티, 비공개 필드와 getter 생성
    var age: Int, // 쓰기 가능 프로퍼티, 비공개 필드와 공개 getter/setter 생성
) {
    override fun toString(): String = "Person(name='$name', age=$age)"
}

fun main() {
    val p = Person2("Assu", 30)

    // 인자가 하나(인자로 받은 사람의 나이를 반환)임
    val personAgeFunction = Person2::age

    println(personAgeFunction(p)) // 30

    // 코틀린 1.1 부터 사용 가능한 바운드 멤버 참조
    // 인자가 없는(참조를 만들 때 p 가 가리키던 사람의 나이를 반환) 함수임
    val boundMemberReferenceAgeFunction = p::age
    println(boundMemberReferenceAgeFunction()) // 30
}
