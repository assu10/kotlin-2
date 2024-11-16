package com.assu.study.kotlin2me.chap11

import java.time.LocalDate
import java.time.Period
import kotlin.test.Test

val Int.days: Period
    get() = Period.ofDays(this) // this 는 상수의 값을 가리팀

val Period.ago: LocalDate
    get() = LocalDate.now() - this

val Period.fromNow: LocalDate
    get() = LocalDate.now() + this  // 연산자 구문을 사용하여 LocalDate.plus() 호출함

class DateTest {
    @Test
    fun test1() {
        val yesterday = 1.days.ago
        val tomorrow = 1.days.fromNow

        println(yesterday) // 2024-11-15
        println(tomorrow) // 2024-11-17
    }
}