package com.assu.study.kotlin2me.chap04

// 추상 클래스이므로 이 클래스의 인스턴스를 만들 수 없음
abstract class Animated {
    // 추상 함수
    // 구현이 없으므로 파생 클래스에서 이 함수를 반드시 오버라이드해야 함
    abstract fun animate()

    // 이 2개 함수는 추상 클래스에 속했더라도 비추상 함수는 기본적으로 final 이지만 원한다면 open 으로 오버라이드 허용 가능
    open fun stopAnimating() {}

    fun animateTwice() {}
}
