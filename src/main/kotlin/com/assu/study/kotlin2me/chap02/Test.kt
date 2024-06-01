package com.assu.study.kotlin2me.chap02

fun main() {
    println("Hello World!")

    val str: String
    str = "abc"

    println(str)

    val message: String

    if (str.length > 1) {
        message = "aa"
    } else {
        message = "bb"
    }

    val lang = arrayListOf("Kotlin", "Java") // 불변 참조 선언
    lang.add("HTML") // 참조가 가리키는 객체 내부 변경

    val a = 42
    println("Found $a") // Found 42
    println("Found \$a") // Found $a
    println("Fount $1") // Found $1

    val s = "my apple"
    println("s = \"$s\"~") // s = "my apple"~
    println("""s = "$s"~""")

    val name = "assu"
    println("Hello $name") // Hello assu
    // println("Hello $name님") // 컴파일 오류
    println("Hello ${name}님") // Hello assu님

    // 중괄호로 둘러싼 식 안에서 큰 따옴표도 사용 가능
    println("hello, ${if (str.length > 1) str else "hoho~"}") // hello, abc
    println("hello, ${if (str.length > 10) str else "hoho~"}") // hello, hoho~
}

fun max(a: Int): Int = if (a > 0) a else 1

// 식이 본문인 함수에서는 반환 타입 생략 가능
fun max1(a: Int) = if (a > 0) a else 1
