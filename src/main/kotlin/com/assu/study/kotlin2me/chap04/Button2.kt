package com.assu.study.kotlin2me.chap04

class Button2 : View {
    override fun getCurrentState(): State = ButtonState()

    override fun restoreState(state: State) {
        // ...
    }

    // 내포된 클래스 (nested class)
    class ButtonState : State {
        // ...
    }
}
