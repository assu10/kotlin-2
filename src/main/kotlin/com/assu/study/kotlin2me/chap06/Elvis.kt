package com.assu.study.kotlin2me.chap06

class Address(val streetAddr: String, val zipCode: Int, val city: String, val country: String)

class Company(val name: String, val addr: Address?)

class Person(val name: String, val company: Company?)

fun shippingLabel(person: Person) {
    // 주소가 없으면 예외 발생
    val address = person.company?.addr ?: throw IllegalArgumentException("No Addr.")

    // address 는 null 이 아님
    with (address) {
        println(this.streetAddr)
        println("$zipCode, $city, $country")
    }
}

fun main() {
    val addr = Address("Aaa", 111, "Bbb", "Ccc")
    val jetbrains = Company("JetBrains", addr)
    val person = Person("Assu", jetbrains)

    // Aaa
    // 111, Bbb, Ccc
    shippingLabel(person)
}