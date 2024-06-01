package com.assu.study.kotlin2me.chap02

enum class Color(val r: Int, val g: Int, val b: Int) {
    // 상수의 프로퍼티 정의
    // 각 상수 생성 시 그에 대한 프로퍼티값 지정
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    GREEN(0, 255, 0),
    ;

    // 추가 메서드 정의
    fun rgb() = (r * 256 + g) * 256 + b
}

fun getColor(color: Color) =
    // 함수 반환값으로 when 식을 직접 사용
    when (color) { // 특정 enum 상수와 같을 때
        Color.RED, Color.GREEN -> "red green~"
        Color.ORANGE -> "orange~"
    }

fun recognize(c: Char) =
    when (c) {
        in '0'..'9' -> "Digit"
        in 'a'..'z', in 'A'..'Z' -> "Letter"
        else -> "Unknown"
    }

fun main() {
    println(getColor(Color.RED)) // red~

    println(recognize('8')) // Digit
    println(recognize('d')) // Letter

    // "java" <= "kotlin" && "kotlin" <= "scala" 와 동일
    println("kotlin" in "java".."scala") // true

    println("kotlin" in setOf("java", "scala")) // false
}
