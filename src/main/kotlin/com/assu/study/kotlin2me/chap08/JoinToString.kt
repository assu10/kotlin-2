package com.assu.study.kotlin2me.chap08

// Collection<T> 에 대한 확장 함수 선언
fun <T> Collection<T>.joinToString(
    separator: String = ", ", // 디폴트 파라메터값들 선언
    prefix: String = "",
    postfix: String = "",
): String {
    val result = StringBuilder(prefix)

    // this 는 수신 객체를 가리킴
    // 여기서는 T 타입의 원소로 이루어진 컬렉션
    for ((index, ele) in this.withIndex()) {
        if (index > 0) {
            result.append(separator)
        }
        result.append(ele)
    }
    result.append(postfix)
    return result.toString()
}

fun main() {
    val list = listOf(1, 2, 3)

    // 1, 2, 3
    println(list.joinToString())

    // (1; 2; 3)
    println(list.joinToString(separator = "; ", prefix = "(", postfix = ")"))
}
