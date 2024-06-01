package com.assu.study.kotlin2me.chap02

import java.io.BufferedReader
import java.io.StringReader

fun readNumber2(reader: BufferedReader) {
    val number =
        try {
            Integer.parseInt(reader.readLine()) // 이 식의 값이 try 식의 값이 됨
        } catch (e: NumberFormatException) {
            null // 예외가 발생하면 null 을 사용
        }
    println(number)
}

fun main() {
    val reader = BufferedReader(StringReader("not a number"))
    readNumber2(reader) // null
}
