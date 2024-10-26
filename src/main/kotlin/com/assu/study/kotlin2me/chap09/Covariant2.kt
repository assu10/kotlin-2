package com.assu.study.kotlin2me.chap09

// 무공변 컬렉션 역할을 하는 클래스 정의
open class Animal2 {
    fun feed() = println("feed~")
}

class Herd2<out T : Animal2> { // T 는 이제 공변적임
    val size: Int
        get() = 1

//    operator fun get(i: Int): T {
//        // ...
//    }
}

// 생성자 파라메터는 in, out 어느 쪽도 아님
// 파라메터 타입이 out 이어도 생성자 파라메터에 선언 가능
class Herd3<out T : Animal2>(
    vararg animals: T,
) {
    // ...
}

class Herd4<T : Animal2>(
    var animal1: T,
    vararg animals: T,
) {
    // ...
}

fun feedAll2(animals: Herd2<Animal2>) {
//    for (i in 0 until animals.size) {
//        animals[i].feed()
//    }
}

// 무공변 컬렉션 역할을 하는 클래스 사용
// Cat 은 Animal 임
open class Cat2 : Animal2() {
    fun cleanLitter() = println("clean litter~")
}

fun takeCareOfCats2(cats: Herd2<Cat2>) {
//    for (i in 0 until cats.size) {
//        cats[i].cleanLitter()
//
//        // 캐스팅을 할 필요가 없음
//        feedAll2(cats)
//    }
}
