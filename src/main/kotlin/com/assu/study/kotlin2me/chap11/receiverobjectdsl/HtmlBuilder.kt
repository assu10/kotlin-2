package com.assu.study.kotlin2me.chap11.receiverobjectdsl

import com.assu.study.kotlin2me.chap08.joinToString

open class Tag(val name: String) {
    // 모든 중첩 태그를 저장함
    private val children = mutableListOf<Tag>()

    // 하위 클래스에서만 볼 수 있도록 protected 가시성 변경자 적용
    protected fun <T: Tag> doInit(child: T, init: T.() -> Unit): Unit {
        child.init() // 자식 태그 초기화
        children.add(child) // 자식 태그에 대한 참조 저장
    }

    override fun toString(): String {
        return "<${name}>${children.joinToString("")}</${name}>"
    }
}

fun table(init: TABLE.() -> Unit): TABLE = TABLE().apply(init)

class TABLE : Tag("table") {
    // tr 함수는 TR 타입을 수신 객체로 받는 람다를 인자로 받음
    // TR 태그 인스턴스를 새로 생성하고, 초기화한 다음에 TABLE 태그의 자식으로 등록
    fun tr(init: TR.() -> Unit): Unit = doInit(TR(), init)
}

class TR : Tag("tr") {
    // td 함수는 TD 타입을 수신 객체로 받는 람다를 인자로 받음
    // TD 태그의 새로운 인스턴스를 생성한 후 TR 태그의 자식으로 등록
    fun td(init: TD.() -> Unit): Unit = doInit(TD(), init)
}

class TD : Tag("td")

fun customCreateTable() =
    table {
        tr {
            td { }
        }
    }

fun createAnotherTable() =
    table {
        for (i in 1..2) {
            tr {
                td { }
            }
        }
    }

fun main() {
    // <table><tr><td></td></tr></table>
    println(customCreateTable())

    // <table><tr><td></td></tr><tr><td></td></tr></table>
    println(createAnotherTable())
}
