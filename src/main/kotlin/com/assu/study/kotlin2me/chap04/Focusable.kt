package com.assu.study.kotlin2me.chap04

interface Focusable1 {
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus.")

    // 디폴트 구현이 있는 메서드
    fun showOff() = println("I'm focusable!")
}

// 같은 모듈 안에서만 볼 수 있는 클래스
internal open class TalkActiveButton : Focusable1 {
    // 같은 클래스 안에서만 볼 수 있는 멤버
    private fun yell() = println("yell~")

    // 하위 클래스 안에서만 볼 수 있는 멤버
    protected fun whisper() = println("whisper~")
}

// 오류: 'public' member exposes its 'internal' receiver type TalkActiveButton
// 오류: public 멤버가 자신의 internal 수신 타입인 TalkActiveButton 을 노출
// fun TalkActiveButton.giveSpeech() {
//    // 오류: Cannot access 'yell': it is private in 'TalkActiveButton'
//    // 오류: yell() 은 TalkActiveButton 의 private 멤버임
//    yell()
//
//    // 오류: Cannot access 'whisper': it is protected in 'TalkActiveButton'
//    // 오류: whisper() 는 TalkActiveButton 의 protected 멤버임
//    whisper()
// }
