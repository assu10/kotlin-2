package com.assu.study.kotlin2me.chap07

import java.time.LocalDate

fun main() {
    val now = LocalDate.now()

    // 오늘을 포함하여 10일 짜리 범위를 만듦 (now <= .. <= now.plusDays(10))
    val vacation = now..now.plusDays(10) // now.rangeTo(now.plusDays(10))

    // 특정 날짜가 날짜 범위 안에 들어가는지 검사
    println(now.plusWeeks(1) in vacation) // true

    val n = 10

    // 012345678910
    (0..n).forEach { print(it) }
//    0..n.forEach { print(it) }
}
