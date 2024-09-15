package com.assu.study.kotlin2me.chap05

// StringBuilder() 를 사용하여 알파벳 생성
fun alphabetWithStringBuilder(): String {
    val result = StringBuilder()
    for (letter in 'A'..'Z') {
        result.append(letter)
    }
    result.append("\nEnd~")
    return result.toString()
}

// BuildString 을 사용하여 알파벳 생성
fun alphabetWithBuildString(): String {
    val result = buildString {
        ('A'..'Z').forEach { append(it) }
        append("\nEnd~")
    }
    return result
}

// joinToString() 을 사용하여 알파벳 생성
fun alphabetWithJoinToString(): String = ('A'..'Z').joinToString(separator = "", postfix = "\nEnd~")

fun main() {
    // 결과는 모두 동일
    // ABCDEFGHIJKLMNOPQRSTUVWXYZ
    //End~

    println(alphabetWithStringBuilder())
    println(alphabetWithBuildString())
    println(alphabetWithJoinToString())
}