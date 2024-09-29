package com.assu.study.kotlin2me.chap07

// 값을 저장하기 위한 data 클래스
data class NameComponents(
    val name: String,
    val extension: String,
)

fun splitFilename(fullName: String): NameComponents {
    val (name, ext) = fullName.split(".", limit = 2)
    return NameComponents(name, ext)
}

fun main() {
    val (name, ext) = splitFilename("test.txt")

    println(name) // test
    println(ext) // ext
}
