package com.assu.study.kotlin2me.chap04

open class View5 {
    // 부생성자
    constructor(a: String) {
        println("View5 $a~")
    }

    // 부생성자
    constructor(a: String, b: Int) {
        println("View5 $a, $b~")
    }
}

class ChildView5 : View5 {
    // 상위 클래스의 생성자 호출
    constructor(a: String) : super(a) {
        println("ChildView5 $a~")
    }

    constructor(a: String, b: Int) : super(a, b) {
        println("ChildView5 $a, $b~")
    }
}

interface AA {
    val email: String
    val nickname: String
        get() = email.substringBefore('@') // 매번 결과를 계산하여 돌려줌
}

fun main() {
    // View5 AA~
    // ChildView5 AA~
    val result = ChildView5("AA")

    // View5 BB, 11~
    // ChildView5 BB, 11~
    val result2 = ChildView5("BB", 11)
}
