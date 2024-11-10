package com.assu.study.kotlin2me.chap11.receiverobjectdsl

// 람다를 인자로 받는 customBuildString() 정의
fun customBuildString(
    builderAction: (StringBuilder) -> Unit, // 함수 타입인 파라메터 정의
): String {
    val sb = StringBuilder()

    // 람다 인자를 StringBuilder 인스턴스를 넘김
    builderAction(sb)

    return sb.toString()
}

fun main() {
    val s =
        customBuildString {
            // it 은 StringBuilder 인스턴스를 가리킴
            it.append("Hello")
            it.append("Assu!")
        }

    // HelloAssu!
    println(s)
}
