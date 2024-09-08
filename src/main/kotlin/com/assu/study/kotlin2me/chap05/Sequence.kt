package com.assu.study.kotlin2me.chap05

data class Person10(
    val name: String,
    val age: Int,
)

fun main() {
    val persons = listOf(Person10("assu", 20), Person10("silby", 2), Person10("jaehun", 22))

    // map() -> filter()
    // 모든 원소에 대해 이름을 가져온 후 길이 필터
    // [assu]
    println(
        persons
            .asSequence()
            .map(Person10::name)
            .filter { it.length < 5 }
            .toList(),
    )

    // filter() -> map()
    // 이름 길이를 먼저 필터한 후 필터된 원소에 대해 이름을 가져오므로 변환되는 크기의 개수가 다름
    // [assu]
    println(
        persons
            .asSequence()
            .filter { it.name.length < 5 }
            .map(Person10::name)
            .toList(),
    )
}
