package com.assu.study.kotlin2me.chap04

class Cookie(
    private var isReady: Boolean, // private 프로퍼티로 클래스 밖에서는 접근 불가
) {
    // private 멤버 함수
    private fun crumble() = println("crumble~")

    // public 멤버 함수로 public 은 불필요한 중복
    public fun bite() = println("bite")

    // 접근 변경자가 없으면 public
    fun eat() {
        isReady = true // 같은 클래스의 멤버만 private 멤버에 접근 가능
        crumble()
        bite()
    }
}
