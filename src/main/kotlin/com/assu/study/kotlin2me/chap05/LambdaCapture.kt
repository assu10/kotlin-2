package com.assu.study.kotlin2me.chap05

fun hello() = println("hello")

fun main() {
    // 최상위 함수 참조
    run(::hello) // run() 은 인자로 받은 람다를 호출함
}
