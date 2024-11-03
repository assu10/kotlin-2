package com.assu.study.kotlin2me.chap10.reflection

fun main() {
    val x: Int = 1

    // 최상위 수준이나 클래스 안에 정의된 멤버 프로퍼티만 리플렉션으로 접근 가능
    // 컴파일 오류
    // References to variables and parameters are unsupported
    // (변수와 파라메터에 대한 참조는 지원하지 않음)

    // val memberProperty = ::x
}
