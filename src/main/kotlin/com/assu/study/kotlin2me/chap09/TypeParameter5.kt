package com.assu.study.kotlin2me.chap09

// null 이 될 수 없는 타입 상한 지정
class Processor2<T : Any> {
    fun process2(value: T) {
        // T 타입의 value 는 null 이 될 수 없으므로 안전한 호출 사용안함
        println(value.hashCode())
    }
}

fun main() {
    // Processor 클래스를 null 이 될 수 있는 타입을 사용하여 인스턴스화함
    val nullableStringProcessor = Processor2<String>()

    // 컴파일 오류
    // nullableStringProcessor.process2(null)

    nullableStringProcessor.process2("ABC") // 64578
}
