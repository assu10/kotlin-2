package com.assu.study.kotlin2me.chap06

class Address2(val streetAddr: String, val zipCode: Int, val city: String, val country: String)

class Company2(val name: String, val addr: Address2?)

class Person2(val name: String, val company: Company2?)

fun main() {
    val person = Person2("AA", null)

    // 아래와 같이 어느 파일의 몇 번째 줄인지에 대한 정보만 나오고 어느 식에서 에러가 발생했는지에 대한 정보는
    // 출력되지 않음

    // Exception in thread "main" java.lang.NullPointerException
    // at com.assu.study.kotlin2me.chap06.NotNullAssertionKt.main(NotNullAssertion.kt:12)
    println(person.company!!.addr!!.city)
}