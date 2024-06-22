package com.assu.study.kotlin2me.chap04

interface Clickable {
    // 일반 메서드 선언
    fun click()

    // 디폴트 구현이 있는 메서드
    fun showOff() = println("I'm clickable!")
}

// 다른 클래스이 이 클래스를 상속할 수 있음
open class RichButton : Clickable {
    // 이 함수는 final 임
    // 파생 클래스가 이 메서드를 오버라이드할 수 없음
    fun disable() {}

    // 이 함수는 열려있음
    // 파생 클래스가 이 메서드를 오버라이드할 수 있음
    open fun animate() {}

    // 이 함수는 기반 클래스에서 열려있는 메서드를 오버라이드한 것임
    // 오버라이드한 메서드는 기본적으로 열려있음
    override fun click() {}
}

interface Focusable {
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus.")

    // 디폴트 구현이 있는 메서드
    fun showOff() = println("I'm focusable!")
}

// showOff() 라는 동일한 메서드를 각각 포함하는 인터페이스 구현
class Button :
    Clickable,
    Focusable {
    override fun click() = println("I was clicked")

    // 이름과 시그니처가 같은 멤버 메서드에 대해 둘 이상의 디폴트 구현이 있는 경우에는
    // 인터페이스를 구현하는 파생 클래스에서 명시적으로 새로운 구현을 제공해야 함
    override fun showOff() {
        // 상위 타입의 이름을 꺽쇠 괄호 <> 사이에 넣어서 super 를 지정하면
        // 어떤 상위 타입의 멤버 메서드를 호출할 지 결정할 수 있음
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}

fun main() {
    val button = Button()
    // I'm clickable!
    // I'm focusable!
    button.showOff()

    // I got focus.
    button.setFocus(true)

    // I was clicked
    button.click()
}
