package com.assu.study.kotlin2me.chap02

import java.io.BufferedReader
import java.io.StringReader

fun readNumber(reader: BufferedReader) {
    val number =
        try {
            Integer.parseInt(reader.readLine()) // 이 식의 값이 try 식의 값이 됨
        } catch (e: NumberFormatException) {
            return // 예외가 발생하면 catch 블록 다음의 코드는 실행되지 않음
        }
    println(number)
}

fun main() {
    val reader = BufferedReader(StringReader("not a number"))
    readNumber(reader) // 아무것도 출력되지 않음
}
