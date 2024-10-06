package com.assu.study.kotlin2me.chap08

data class SiteVisit2(
    val path: String,
    val duration: Double, // 사이트에 머문 시간
    val os: OS2,
)

enum class OS2 {
    WINDOWS,
    LINUX,
    MAC,
    IOS,
    ANDROID,
}

val log2 =
    listOf(
        SiteVisit2("/", 34.0, OS2.WINDOWS),
        SiteVisit2("/", 22.0, OS2.MAC),
        SiteVisit2("/login", 12.0, OS2.WINDOWS),
        SiteVisit2("/signup", 8.0, OS2.IOS),
        SiteVisit2("/", 16.3, OS2.ANDROID),
    )

// 모바일 디바이스 사용자의 평균 방문 시간 (하드 코딩이 들어감)
val averageMobileDuration =
    log2
        .filter { it.os in setOf(OS2.IOS, OS2.ANDROID) }
        .map(SiteVisit2::duration)
        .average()

fun main() {
    // 12.15
    println(averageMobileDuration)
}
