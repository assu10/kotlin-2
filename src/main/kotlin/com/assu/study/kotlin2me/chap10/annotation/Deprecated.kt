package com.assu.study.kotlin2me.chap10.annotation

@Deprecated("Use removeNew(index) instead", ReplaceWith("removeNew(index)"))
fun remove(index: Int) {
    // ...
}

fun removeNew(index: Int) {
    // ...
}

fun main() {
    remove(1)
}
