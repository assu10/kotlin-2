package com.assu.study.kotlin2me.chap11.receiverobjectdsl

// 수신 객체 지정 람다를 사용한 customBuildString()
fun customBuildString2(
    builderAction: StringBuilder.() -> Unit, // 수신 객체가 있는 함수 타입의 파라메터 선언
): String {
    val sb = StringBuilder()

    // StringBuilder 인스턴스를 람다의 수신 객체로 넘김
    sb.builderAction()

    return sb.toString()
}

fun main() {
    val s =
        customBuildString2 {
            // this 는 StringBuilder 인스턴스를 가리킴
            this.append("Hello")

            // this 를 생략해도 묵시적으로 StringBuilder 인스턴스가 수신 객체로 취급됨
            append("Assu!")
        }

    // HelloAssu!
    println(s)
}
