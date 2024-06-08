package com.assu.study.kotlin2me.chap03

fun parsePathWithRegex(path: String) {
    // 삼중 따옴표를 사용하여 정규식을 사용하면 역슬래시를 포함한 어떤 문자도 이스케이프할 필요 없음
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null) {
        val (dir, filename, extension) = matchResult.destructured
        println("dir: $dir, filename: $filename, extension: $extension")
    }
}

fun main() {
    val path = "/Users/assu/kotlin-book/aaa.txt"

    // dir: /Users/assu/kotlin-book, filename: aaa, extension: txt
    parsePathWithRegex(path)
}
