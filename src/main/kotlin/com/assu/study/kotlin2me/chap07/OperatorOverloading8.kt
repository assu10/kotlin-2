package com.assu.study.kotlin2me.chap07

import java.math.BigDecimal

operator fun BigDecimal.inc() = this + BigDecimal.ONE

fun main() {
    var d = BigDecimal.ZERO

    // 후위 증가 연산자는 println() 이 실행된 후 값 증가
    println(d++) // 0

    // 전위 증가 연산자는 println() 이 실행되기 전에 값 증가
    println(++d) // 2
}
