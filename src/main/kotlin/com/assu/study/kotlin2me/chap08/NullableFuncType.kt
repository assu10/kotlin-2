package com.assu.study.kotlin2me.chap08

fun foo(callback: (() -> Unit)?) {
    // ...
    if (callback != null) {
        callback()
    }
}
