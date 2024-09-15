package com.assu.study.kotlin2me.chap05

fun alphabetApply() = StringBuilder().apply {
    ('A'..'Z').forEach { append(it) }
    append("\nEnd~")
}.toString()

fun alphabetApplyWithBuildString() = buildString {
    ('A'..'Z').forEach { append(it) }
    append("\nEnd~")
}

fun main() {
    // ABCDEFGHIJKLMNOPQRSTUVWXYZ
    // End~
    println(alphabetApply())
    println(alphabetApplyWithBuildString())
}