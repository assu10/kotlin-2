package com.assu.study.kotlin2me.chap11.receiverobjectdsl

// 수신 객체 지정 람다를 변수에 저장
// appendExcl 은 확장 함수 타입의 값임
val appendExcl: StringBuilder.() -> Unit = {
    // this 는 StringBuilder 임
    this.append("Hello")
}

fun main() {
    val sb = StringBuilder("Assu")

    // appendExcl() 을 확장 함수처럼 호출
    sb.appendExcl()

    // AssuHello
    println(sb)

    // appendExcl 을 인자로 넘길 수 있음
    println(buildString(appendExcl)) // Hello
}
