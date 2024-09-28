package com.assu.study.kotlin2me.chap07

class Person(
    val firstName: String,
    val lastName: String,
) : Comparable<Person> {
    override operator fun compareTo(other: Person): Int {
        // 인자로 받은 함수를 차례로 호출하면서 값을 비교
        // 성을 비교하여 성이 같으면 이름을 비교함
        return compareValuesBy(this, other, Person::lastName, Person::firstName)
    }
}

fun main() {
    val person1 = Person("Assu", "ASmith")
    val person2 = Person("Bob", "BJohnson")
    val person3 = Person("Aarol", "BJohnson")

    println(person1 > person2) // false (person1: Asmith, person2 BJohnson)
    println(person2 > person3) // true (person1: Bob, person2: Aarol)

    println("abc" > "bdc") // false
}
