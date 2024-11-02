package com.assu.study.kotlin2me.chap10.reflection

import kotlin.reflect.KClass
import kotlin.reflect.full.memberProperties // memberProperties 확장 함수 임포트

class Person(
    val name: String,
    val age: Int,
)

fun main() {
    val person = Person("Assu", 20)
    val clazz: Class<Person> = person.javaClass
    val kClazz: KClass<Person> = person.javaClass.kotlin

    // Person
    println(clazz.simpleName)

    // Person
    println(kClazz.simpleName)

    // memberProperties 를 통해 클래스와 모든 조상 클래스 내부에 정의된 비확장 프로퍼티를 가져옴
    // age
    // name
    kClazz.memberProperties.forEach { println(it.name) }
}
