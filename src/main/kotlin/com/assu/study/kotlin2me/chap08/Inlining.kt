package com.assu.study.kotlin2me.chap08

import java.util.concurrent.locks.Lock

inline fun <T> customSynchronized(
    lock: Lock,
    action: () -> T,
): T {
    lock.lock()

    try {
        return action()
    } finally {
        lock.unlock()
    }
}

fun foo(lock: Lock) {
    println("Before sync")
    customSynchronized(lock) {
        println("Action")
    }
    println("After sync")
}

fun main() {
//    val lock = Lock()
//    customSynchronized(lock) {
//        // ..
//    }
}
