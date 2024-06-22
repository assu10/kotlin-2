package com.assu.study.kotlin2me.chap04

import java.io.Serializable

// View 를 직렬화하기 위해 선언한 인터페이스
interface State : Serializable

interface View {
    fun getCurrentState(): State

    fun restoreState(state: State) {}
}
