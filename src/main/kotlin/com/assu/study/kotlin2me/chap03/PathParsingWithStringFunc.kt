package com.assu.study.kotlin2me.chap03

fun parsePath(path: String) {
    val dir = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")
    val filename = fullName.substringBeforeLast(".")
    val ext = fullName.substringAfterLast(".")

    println("dir: $dir, filename: $filename, ext: $ext")
}

fun main() {
    val path = "/Users/assu/kotlin-book/aaa.txt"

    // dir: /Users/assu/kotlin-book, filename: aaa, ext: txt
    parsePath(path)
}
