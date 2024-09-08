package com.assu.study.kotlin2me.chap05

import java.io.File

// 상위 디렉터리를 뒤지면서 숨김 속성을 가진 디렉터리가 있는지 검사
// any() 를 find() 로 변경하면 원하는 디렉터리를 찾을 수 있음
// 이렇게 시퀀스를 사용하면 조건을 만족하는 디렉터리를 찾은 뒤에는 더 이상 상위 디렉터리를 뒤지지 않음
fun File.isInsideHiddenDir() = generateSequence(this) { it.parentFile }.any { it.isHidden }

fun main() {
    val file = File("/Users/assu/.HiddenDir/a.txt")

    // true
    println(file.isInsideHiddenDir())
}
