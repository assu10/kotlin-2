package com.assu.study.kotlin2me.chap02

class Person2(
    val name: String, // 읽기 전용 프로퍼티, 비공개 필드와 getter 생성
    var isMarried: Boolean, // 쓰기 가능 프로퍼티, 비공개 필드와 공개 getter/setter 생성
)

fun main(args: Array<String>) {
    // new 키워드를 사용하지 않음
    val person = Person2("Assu", true)

    // 프로퍼티 이름을 직접 사용해도 코틀린이 자동으로 getter 를 호출해줌
    println(person.name) // Assu
    println(person.isMarried) // true
}
