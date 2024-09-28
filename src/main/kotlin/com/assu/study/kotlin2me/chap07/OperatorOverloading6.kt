package com.assu.study.kotlin2me.chap07

fun main() {
    // val 로 선언한 변수에 변경 가능한 컬렉션 지정
    val list = arrayListOf(1, 2)
    list += 3 // += 는 list 를 변경함

    // [1, 2, 3]
    println(list)

    // var 로 선언한 변수에 변경 불가능한 컬렉션 지정
    // + 는 두 리스트의 모든 원소를 포함하는 새로운 리스트 반환
    var list2 = list + listOf(4, 5)

    // [1, 2, 3, 4, 5]
    println(list2)
}
