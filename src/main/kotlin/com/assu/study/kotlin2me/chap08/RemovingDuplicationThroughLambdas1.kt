package com.assu.study.kotlin2me.chap08

data class SiteVisit1(
    val path: String,
    val duration: Double, // 사이트에 머문 시간
    val os: OS1,
)

enum class OS1 {
    WINDOWS,
    LINUX,
    MAC,
    IOS,
    ANDROID,
}

val log1 =
    listOf(
        SiteVisit1("/", 34.0, OS1.WINDOWS),
        SiteVisit1("/", 22.0, OS1.MAC),
        SiteVisit1("/login", 12.0, OS1.WINDOWS),
        SiteVisit1("/signup", 8.0, OS1.IOS),
        SiteVisit1("/", 16.3, OS1.ANDROID),
    )

// 중복 코드를 별도 함수로 추출하여 확장 함수 선언
fun List<SiteVisit1>.averageDurationFor(os: OS1) =
    filter { it.os == os }
        .map(SiteVisit1::duration)
        .average()

fun main() {
    // 22.0
    println(log1.averageDurationFor(OS1.MAC))
}
