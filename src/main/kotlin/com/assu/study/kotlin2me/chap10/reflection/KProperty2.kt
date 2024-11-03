package com.assu.study.kotlin2me.chap10.reflection

import kotlin.reflect.KProperty1

class People(
    val name: String,
    val age: Int,
)

class People2(
    val name: String,
    val age: Int,
    val name2: String,
    val name3: String,
    val name4: String,
)

fun main() {
    val people = People("Assu", 20)

    // memberProperty 변수에 프로퍼티 참조 저장
    val memberProperty: KProperty1<People, Int> = People::age

    // people 인스턴스의 프로퍼티값 가져옴
    // 20
    println(memberProperty.get(people))

    val people2 = People2("111", 1, "11", "22", "33")
    val mem = People2::age
}
