package com.assu.study.kotlin2me.chap08

data class SiteVisit3(
    val path: String,
    val duration: Double, // 사이트에 머문 시간
    val os: OS3,
)

enum class OS3 {
    WINDOWS,
    LINUX,
    MAC,
    IOS,
    ANDROID,
}

val log3 =
    listOf(
        SiteVisit3("/", 34.0, OS3.WINDOWS),
        SiteVisit3("/", 22.0, OS3.MAC),
        SiteVisit3("/login", 12.0, OS3.WINDOWS),
        SiteVisit3("/signup", 8.0, OS3.IOS),
        SiteVisit3("/", 16.3, OS3.ANDROID),
    )

// 고차 함수를 이용하여 중복 제거
fun List<SiteVisit3>.averageDurationFor(predicate: (SiteVisit3) -> Boolean) = filter(predicate).map(SiteVisit3::duration).average()

fun main() {
    // 12.15
    println(log3.averageDurationFor { it.os in setOf(OS3.IOS, OS3.ANDROID) })

    // 8.0
    println(log3.averageDurationFor { it.os == OS3.IOS && it.path == "/signup" })
}
