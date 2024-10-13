package com.assu.study.kotlin2me.chap09

interface List<T> {
    operator fun get(index: Int): T
}

// List<T> 인터페이스를 구현하는 클래스
// 구체적인 타입 인자로 String 을 지정하여 List 인터페이스 구현
class StringList : List<String> {
    override fun get(index: Int): String {
        TODO("Not yet implemented")
    }
}

// ArrayList 의 제네릭 타입 파라메터 T 를 List 의 타입 인자로 넘김
class ArrayList<T> : List<T> {
    override fun get(index: Int): T {
        TODO("Not yet implemented")
    }
}

interface Comparable<T> {
    fun compareTo(other: T): Int
}

class String1 : Comparable<String1> {
    override fun compareTo(other: String1): Int {
        TODO("Not yet implemented")
    }
}
