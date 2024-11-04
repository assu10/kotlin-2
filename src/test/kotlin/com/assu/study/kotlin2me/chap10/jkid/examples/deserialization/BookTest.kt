package com.assu.study.kotlin2me.chap10.jkid.examples.deserialization

import ru.yole.jkid.deserialization.deserialize

data class Author(
    val name: String,
)

data class Book(
    val title: String,
    val author: Author,
)

fun main() {
    val json = """{"title": "TEST1", "author": {"name": "Assu"}}"""

    // 역직렬화할 객체의 타입을 실체화한 타입 파라메터로 deserialize() 에 넘겨서 새로운 객체 인스턴스를 얻음
    val book: Book = deserialize<Book>(json)

    // Book(title=TEST1, author=Author(name=Assu))
    println(book)
}
