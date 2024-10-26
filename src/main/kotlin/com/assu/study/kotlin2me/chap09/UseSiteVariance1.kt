package com.assu.study.kotlin2me.chap09

// 무공변 파라메터 타입을 사용하는 데이터 복사 함수
fun <T> copyData(
    source: MutableList<T>,
    dest: MutableList<T>,
) {
    for (item in source) {
        dest.add(item)
    }
}

// 타입 파라메터가 두 개인 데이터 복사 함수
// source 의 원소타입 T 는 dest 의 원소타입 R 의 하위 타입이어야 함
fun <T : R, R> copyData2(
    source: MutableList<T>,
    dest: MutableList<R>,
) {
    for (item in source) {
        dest.add(item)
    }
}

// out 프로젝션 타입 파라메터를 사용하는 데이터 복사 함수
fun <T> copyData3(
    source: MutableList<out T>,
    dest: MutableList<T>,
) {
    for (item in source) {
        dest.add(item)
    }
}

// in,out 프로젝션 타입 파라메터를 사용하는 데이터 복사 함수
// in 프로젝션을 하여 원본 리스트 원소 타입의 상위 타입을 대상 리스트 원소 타입으로 허용함
fun <T> copyData4(
    source: MutableList<out T>,
    dest: MutableList<in T>,
) {
    for (item in source) {
        dest.add(item)
    }
}

fun main() {
    val ints = mutableListOf(1, 2)
    val anyItems = mutableListOf<Any>()

    // Int 는 Any 의 하위 타입이므로 함수 호출 가능
    copyData2(ints, anyItems)

    // [1, 2]
    println(anyItems)
}
