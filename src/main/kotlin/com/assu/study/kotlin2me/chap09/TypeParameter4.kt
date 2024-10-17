package com.assu.study.kotlin2me.chap09

class Processor<T> {
    fun process1(value: T) {
        // value 는 null 이 될 수 있으므로 안전한 호출 사용
        println(value?.hashCode())
    }

    fun process2(value: T) {
        println(value.hashCode())
    }
}

fun main() {
    val nullableStringProcessor = Processor<String?>()

    nullableStringProcessor.process1(null) // null
    nullableStringProcessor.process2(null) // 0
}
