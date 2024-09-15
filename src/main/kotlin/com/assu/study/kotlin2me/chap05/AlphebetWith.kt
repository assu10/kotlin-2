package com.assu.study.kotlin2me.chap05

fun alphabetWith(): String {
    val result = StringBuilder()
    return with(result) {   // 메서드를 호출하려는 수신 객체 지정
        for (letter in 'A'..'Z') {
            this.append(letter) // this 를 명시해서 앞에서 지정한 수신 객체의 메서드 호출
        }
        append("\nEnd~")    // this 를 생략하고 메서드 호출
        this.toString() // 람다에서 값 반환
    }
}

fun alphabetWith2() = with(StringBuilder()) {
    ('A'..'Z').forEach { append(it) }
    append("\nEnd~")
    this@with.toString()
}

fun main() {
    // 결과는 모두 동일
    // ABCDEFGHIJKLMNOPQRSTUVWXYZ
    // End~
    println(alphabetWith())
    println(alphabetWith2())
}