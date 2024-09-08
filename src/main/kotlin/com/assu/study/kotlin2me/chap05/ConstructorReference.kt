package com.assu.study.kotlin2me.chap05

class Person(
    private val name: String, // 읽기 전용 프로퍼티, 비공개 필드와 getter 생성
    private var age: Int, // 쓰기 가능 프로퍼티, 비공개 필드와 공개 getter/setter 생성
) {
    override fun toString(): String = "Person(name='$name', age=$age)"
}

fun main() {
    // Person 의 인스턴스를 만드는 동작을 값으로 저장
    val createPersonInstance = ::Person

    val p = createPersonInstance("ASSU", 20)

    // Person(name='ASSU', age=20)
    println(p)
}
