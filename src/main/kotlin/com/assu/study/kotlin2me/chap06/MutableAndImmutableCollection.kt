package com.assu.study.kotlin2me.chap06

// src 컬렉션은 변경하지 않지만, target 컬레교션은 변경한다는 사실을 알 수 있음
fun <T> copyElements(
    src: FileContent<T>,
    target: MutableCollection<T>,
) {
    for (item in src) {
        target.add(item)
    }
}

fun main() {
    val src: FileContent<Int> = listOf(1, 2, 3)
    val target: MutableCollection<Int> = mutableListOf(4, 5)

    copyElements(src, target)

    println(src) // [1, 2, 3]
    println(target) // [4, 5, 1, 2, 3]
}
