package com.assu.study.kotlin2me.chap08

data class SiteVisit(
    val path: String,
    val duration: Double, // 사이트에 머문 시간
    val os: OS,
)

enum class OS {
    WINDOWS,
    LINUX,
    MAC,
    IOS,
    ANDROID,
}

val log =
    listOf(
        SiteVisit("/", 34.0, OS.WINDOWS),
        SiteVisit("/", 22.0, OS.MAC),
        SiteVisit("/login", 12.0, OS.WINDOWS),
        SiteVisit("/signup", 8.0, OS.IOS),
        SiteVisit("/", 16.3, OS.ANDROID),
    )

// 윈도우 사용자에 대해 머문 시간의 평균을 하드 코딩한 필터를 사용하여 분석
val averageWindowsDuration =
    log
        .filter { it.os == OS.WINDOWS }
        .map(SiteVisit::duration)
        .average()

fun main() {
    // 23.0
    println(averageWindowsDuration)
}
