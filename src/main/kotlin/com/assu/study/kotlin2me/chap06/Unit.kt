package com.assu.study.kotlin2me.chap06

// 인터페이스의 시그니처는 process() 가 어떤 값을 반환하도록 명세됨
interface Processor<T> {
    fun process(): T
}

class NoResultProcessor : Processor<Unit> {
    // Unit 을 반환하지만 타입을 지정할 필요는 없음
    override fun process() {
        // ...
        // 여기서 return 을 지정할 필요없음
    }
}
