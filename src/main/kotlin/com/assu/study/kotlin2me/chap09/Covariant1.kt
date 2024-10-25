package com.assu.study.kotlin2me.chap09

// 무공변 컬렉션 역할을 하는 클래스 정의
open class Animal {
    fun feed() = println("feed~")
}

class Herd<T : Animal> { // 이 타입 파라메터를 무공변성으로 지정
    val size: Int
        get() = 1

    operator fun get(i: Int): T {
        // ...
    }
}

fun feedAll(animals: Herd<Animal>) {
    for (i in 0 until animals.size) {
        animals[i].feed()
    }
}

// 무공변 컬렉션 역할을 하는 클래스 사용
// Cat 은 Animal 임
open class Cat : Animal() {
    fun cleanLitter() = println("clean litter~")
}

fun takeCareOfCats(cats: Herd<Cat>) {
    for (i in 0 until cats.size) {
        cats[i].cleanLitter()

        // 컴파일 오류
        // Type mismatch.
        // Required:Herd<Animal>
        // Found:Herd<Cat>

        feedAll(cats)
    }
}
