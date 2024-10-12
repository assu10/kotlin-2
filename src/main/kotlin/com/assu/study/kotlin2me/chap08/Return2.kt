package com.assu.study.kotlin2me.chap08

data class Person4(
    val name: String,
    val age: Int,
)

val person4 = listOf(Person4("Assu", 20), Person4("Silby", 25))

// 레이블을 사용하여 local return 사용
fun lookForAssu(person: List<Person4>) {
    person.forEach label@{
        // 람다식 앞에 레이블을 붙임
        if (it.name == "Assu") {
            return@label // return@label 은 앞에서 정의한 레이블을 참조함
        }

        // 항상 이 줄이 실행됨
        println("Assu might be somewhere...")
    }
}

// 레이블을 사용하여 local return 사용
fun lookForAssu1(person: List<Person4>) {
    person.forEach {
        // 람다식 앞에 레이블을 붙임
        if (it.name == "Assu") {
            return@forEach // return@forEach 는 람다식으로부터 반환시킴
        }

        // 항상 이 줄이 실행됨
        println("Assu might be somewhere...")
    }
}

fun main() {
    lookForAssu(person4) // Assu might be somewhere...

    val a =
        // this@sb 를 통해 이 람다의 묵시적 수신 객체에 접근 가능
        StringBuilder().apply sb@{
            // this 는 이 위치를 둘러싼 가장 안쪽 영역의 묵시적 수신 객체를 가리킴
            listOf(1, 2, 3).apply {
                // 모든 묵시적 수신 객체를 사용할 수 있지만 바깥쪽 묵시적 수신 객체에 접근할 때는 레이블 명시
                this@sb.append(this.toString())
            }
        }

    println(a) // [1, 2, 3]
}
