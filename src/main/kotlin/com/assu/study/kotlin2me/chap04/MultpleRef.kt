package com.assu.study.kotlin2me.chap04

class Counter(
    var start: Int,
) {
    fun incr() {
        start += 1
    }

    override fun toString() = start.toString()
}

class CounterHolder(
    counter: Counter,
) {
    private val ctr = counter

    override fun toString() = "CounterHolder: $ctr~"
}

fun main() {
    // 아랫줄의 CountHolder 객체 생성을 둘러싸고 있는 영역 안에 정의됨
    val c = Counter(11)

    // c 를 CounterHolder 생성자의 인자로 전달하는 것은 새로 생긴 CountHolder 객체가 c 가 가리키는 Counter 객체와
    // 똑같은 객체를 참조할 수 있다는 의미임
    val ch = CounterHolder(c)

    // CounterHolder: 11~
    println(ch)

    // ch 안에서는 여전에 private 로 인식되는 Counter 를 여전히 c 를 통해 조작 가능
    c.incr()

    // CounterHolder: 12~
    println(ch)

    // CounterHolder 안에 있는 ctr 외에는 Counter(9) 를 가리키는 참조가 존재하지 않으므로
    // ch2 를 제외한 그 누구도 이 객체를 조작할 수 없음
    val ch2 = CounterHolder(Counter(9))

    // CounterHolder: 9~
    println(ch2)
}
