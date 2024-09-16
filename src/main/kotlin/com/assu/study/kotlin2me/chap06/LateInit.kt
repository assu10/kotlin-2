package com.assu.study.kotlin2me.chap06



class MyService {
    fun action(): String = "foo"
}

// 널 아님 단언 `!!` 을 사용하여 null 이 될 수 있는 프로퍼티 접근
class MyTest {
    // null 로 초기화하기 위해 null 이 될 수 있는 타입인 프로퍼티 선언
    private var myService: MyService? = null

    fun setUp() {
        // setUp() 안에서 진짜 초기값 지정
        myService = MyService()
    }

    fun testAction() {
        // 널 아님 단언 `!!` 이나 안전한 호출 `?.` 을 꼭 사용해야 함
        myService!!.action()
        myService?.action()
    }
}

// 나중에 초기화하는 프로퍼티 사용
class MyTestWithLateInit {
    // 초기화하지 않고 null 이 될 수 없는 프로퍼티 선언
    private lateinit var myService: MyService

    fun setUp() {
        // setUp() 안에서 진짜 초기값 지정
        myService = MyService()
    }

    fun testAction() {
        // null 검사를 수행하지 않고 프로퍼티 사용
        myService.action()
    }
}