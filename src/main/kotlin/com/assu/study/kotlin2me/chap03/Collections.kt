package com.assu.study.kotlin2me.chap03

fun main() {
    val set = hashSetOf(1, 1, 2)
    val list = arrayListOf(1, 1, 2)
    val list2 = listOf(1, 1, 2)
    val hashmap = hashMapOf(1 to "one", 2 to "two")

    println(set) // [1, 2]
    println(list) // [1, 1, 2]
    println(list2) // [1, 1, 2]
    println(hashmap) // {1=one, 2=two}

    // javaClass 는 자바에서 getClass() 와 동일
    println(set.javaClass) // class java.util.HashSet
    println(list.javaClass) // class java.util.ArrayList
    println(list2.javaClass) // class java.util.Arrays$ArrayList
    println(hashmap.javaClass) // class java.util.HashMap

    println(list.last()) // 2
    println(set.max()) // 2
}
