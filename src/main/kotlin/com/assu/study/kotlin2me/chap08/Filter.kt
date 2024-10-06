package com.assu.study.kotlin2me.chap08

// 문자열의 각 문자를 Predicate 로 넘겨서 반환값이 true 이면 결과에 그 문자를 추가
fun String.filter(predicate: (Char) -> Boolean): String {
    val sb = StringBuilder()
    for (index in indices) {
        val ele = get(index)
        // predicate 파라메터로 전달받은 함수 호출
        if (predicate(ele)) {
            sb.append(ele)
        }
    }
    return sb.toString()
}

fun main() {
    // 람다를 predicate 파라메터로 전달
    println("abcf".filter { it in 'a'..'z' }) // abcf
    println("abcㄹ".filter { it in 'a'..'z' }) // abc
}
