package com.assu.study.kotlin2me.chap05

fun main() {
    val list = listOf(1, 2, 3)

    // 모든 원소 중 적어도 하나는 3이 아닌지 확인

    // ! 를 보지 못할수도 있으므로 아래 식 보다는 any() 사용 추천
    // true
    println(!list.all { it == 3 })

    // 가독성을 위해 아래를 권장
    // true
    println(list.any { it != 3 })
}
