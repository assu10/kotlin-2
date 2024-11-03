package com.assu.study.kotlin2me.chap10.reflection

import kotlin.reflect.KMutableProperty0

var counter = 0

fun main() {
    val kProperty: KMutableProperty0<Int> = ::counter

    // 리플렉션 기능을 통해 setter 를 호출하면서 21 을 인자로 넘김
    kProperty.setter.call(21)

    // 21
    // get() 을 호출하여 프로퍼티값을 가져옴
    println(kProperty.get())
}
