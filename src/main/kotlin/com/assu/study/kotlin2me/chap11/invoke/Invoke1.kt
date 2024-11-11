package com.assu.study.kotlin2me.chap11.invoke

class Greeter(val greeting: String) {
    // Greeter 클래스 안에 invoke() 메서드 정의
    operator fun invoke(name: String) {
        println("$greeting, $name~")
    }
}

fun main() {
    val greeter = Greeter("Hi")

    // Greeter 인스턴스를 함수처럼 호출
    greeter("Assu") // Hi, Assu!
}
