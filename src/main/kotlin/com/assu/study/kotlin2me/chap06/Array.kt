package com.assu.study.kotlin2me.chap06

fun main() {
    val arr: Array<String> = arrayOf("a", "b")

    // 배열의 인덱스 값 범위에 대해 이터레이션 하기 위해 array.indices 확장 함수 사용
    for (i in arr.indices) {
        println("arg $i is : ${arr[i]}")
    }

    // arg 0 is : a
    // arg 1 is : b

    val letters = Array<String>(26) { i -> ('a' + i).toString() }

    // [Ljava.lang.String;@3b07d329
    println(letters)

    // abcdefghijklmnopqrstuvwxyz
    println(letters.joinToString(""))
}
