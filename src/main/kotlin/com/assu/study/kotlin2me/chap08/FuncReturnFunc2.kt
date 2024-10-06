package com.assu.study.kotlin2me.chap08

data class Person(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String?,
)

class ContactListFilters {
    var prefix: String = ""
    var onlyWithPhoneNumber: Boolean = false

    // 함수를 반환하는 함수를 정의
    fun getPredicate(): (Person) -> Boolean {
        val startsWithPrefix = { p: Person ->
            p.firstName.startsWith(prefix) ||
                p.lastName.startsWith(prefix)
        }

        if (!onlyWithPhoneNumber) {
            // 함수 타입의 변수 반환
            return startsWithPrefix
        }

        // 람다 반환
        return { startsWithPrefix(it) && it.phoneNumber != null }
    }
}

fun main() {
    val contacts =
        listOf(
            Person("AAA", "aaa", "123-4567"),
            Person("BBB", "bbb", null),
        )

    val contactListFilters = ContactListFilters()

    with(contactListFilters) {
        prefix = "A"
        onlyWithPhoneNumber = true
    }

    // getPredicate() 가 반환한 함수를 filter 에게 인자로 넘김

    // [Person(firstName=AAA, lastName=aaa, phoneNumber=123-4567)]
    println(contacts.filter(contactListFilters.getPredicate()))
}
