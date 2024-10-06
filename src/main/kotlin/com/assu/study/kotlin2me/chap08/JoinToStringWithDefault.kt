package com.assu.study.kotlin2me.chap08

// Collection<T> 에 대한 확장 함수 선언
fun <T> Collection<T>.joinToString2(
    separator: String = ", ", // 디폴트 파라메터값들 선언
    prefix: String = "",
    postfix: String = "",
    // 함수 타입 파라메터를 선언하면서 람다를 디폴트값으로 지정
    transform: (T) -> String = { it.toString() },
): String {
    val result = StringBuilder(prefix)

    // this 는 수신 객체를 가리킴
    // 여기서는 T 타입의 원소로 이루어진 컬렉션
    for ((index, ele) in this.withIndex()) {
        if (index > 0) {
            result.append(separator)
        }
        result.append(transform(ele))
    }
    result.append(postfix)
    return result.toString()
}

fun main() {
    val list = listOf(1, 2, 3)

    // 1, 2, 3
    println(list.joinToString2())

    // (1; 2; 3)
    println(list.joinToString2(separator = "; ", prefix = "(", postfix = ")"))

    val letters = listOf("Alpha", "Beta")

    // 디폴트 변환 함수 사용
    println(letters.joinToString2()) // Alpha, Beta

    // 람다를 인자로 전달
    println(letters.joinToString2 { it.lowercase() }) // alpha, beta

    // 이름 붙인 인자 구문을 사용하여 람다를 포함하는 여러 인자 전달
    println(letters.joinToString2(separator = "! ", postfix = "~ ", transform = { it.uppercase() })) // ALPHA! BETA~
}
