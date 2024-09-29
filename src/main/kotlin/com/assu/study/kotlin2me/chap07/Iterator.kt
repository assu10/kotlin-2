package com.assu.study.kotlin2me.chap07

import java.time.LocalDate

operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =

    // 이 object 는 LocalDate 원소에 대한 Iterator 를 구현함
    object : Iterator<LocalDate> {
        var current = start

        // compareTo() 관례를 사용하여 날짜 비교
        // `endInclusive`: The maximum value in the range (inclusive).
        override fun hasNext(): Boolean = current <= endInclusive

        // 현재 날짜를 저장한 다음에 날짜를 변경
        // 그 후 저장해 둔 날짜를 반환
        // 현재 날짜를 1일 뒤로 변경
        override fun next(): LocalDate = current.apply { current = plusDays(1) }
    }

fun main() {
    val newYear = LocalDate.ofYearDay(2024, 1)
    val daysOff = newYear.minusDays(1)..newYear

    println(newYear) // 2024-01-01
    println(daysOff) // 2023-12-31..2024-01-01

    // daysOff 에 대응하는 iterator() 함수가 있으면 daysOff 에 대해 이터레이션

    // 2023-12-31
    // 2024-01-01
    for (dayOff in daysOff) {
        println(dayOff)
    }
}
