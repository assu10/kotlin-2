package com.assu.study.kotlin2me.chap05

data class Book(
    val title: String,
    val authors: List<String>,
)

fun main() {
    val books = listOf(Book("A", listOf("AA")), Book("B", listOf("BB", "AA")), Book("C", listOf("CC", "BB")))

    // [AA, BB, AA, CC, BB]
    println(books.flatMap { it.authors })

    // 컬렉션에 있는 모든 저자에 대해 중복 제거
    // [AA, BB, CC]
    println(books.flatMap { it.authors }.toSet())

    val strings = listOf("abc", "def")

    //  map() 과 toList() 사용하면 문자열로 이루어진 리스트로 이루어진 리스트가 생성됨
    // [[a, b, c], [d, e, f]]
    println(strings.map { it.toList() })

    // flatMap() 은 리스트의 리스트에 들어있던 모든 원소를 단일 리스트로 반환함
    // [a, b, c, d, e, f]
    println(strings.flatMap { it.toList() })
}
