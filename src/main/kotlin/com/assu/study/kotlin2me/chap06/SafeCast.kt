package com.assu.study.kotlin2me.chap06

class Person1(val firstName: String, val lastName: String) {
    override fun equals(other: Any?): Boolean {
        // 타입이 서로 일치하지 않으면 false 반환
        val otherPerson = other as? Person1 ?: return false

        // 안전한 캐스트를 하고나면 otherPerson 이 Person1 타입으로 스마트 캐스트 됨
        return otherPerson.firstName == firstName &&
                otherPerson.lastName == lastName
    }

    override fun hashCode(): Int =
        firstName.hashCode() * 37 + lastName.hashCode()
}

fun main() {
    val p1 = Person1("AA", "BB")
    val p2 = Person1("AA", "BB")

    // == 연산자는 equals() 메서드를 호출함
    println(p1 == p2)   // true
    println(p1.equals(11))  // false
}