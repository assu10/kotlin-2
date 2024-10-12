package com.assu.study.kotlin2me.chap08

data class Person5(
    val name: String,
    val age: Int,
)

val person5 = listOf(Person5("Assu", 20), Person5("Silby", 25))

// 무명 함수 안에서 return 사용
fun lookForAssu(person: List<Person5>) {
    // 람다식 대신 무명 함수 사용
    person.forEach(fun(p) {
        if (p.name == "Assu") {
            // return 은 가장 가까운 함수를 가리킴
            // 여기서 가장 가까운 함수는 무명 함수임
            return
        }
        println("${p.name} is not Assu")
    })
}

fun main() {
    lookForAssu(person5) // Silby is not Assu

    // filter() 에 무명 함수 넘기기
    val filter = person5.filter(fun(p): Boolean = p.age < 25)

    println(filter) // [Person5(name=Assu, age=20)]
}
