package com.assu.study.kotlin2me.chap09

import java.security.Provider.Service
import java.util.ServiceLoader

// 읽어들일 서비스 클래스를 함수의 타입 인자로 지정
// 타입 파라메터를 reified 로 지정
inline fun <reified T> loadService(): ServiceLoader<T> {
    // T::class 로 타입 파라메터의 클래스를 가져옴
    return ServiceLoader.load(T::class.java)
}

fun main() {
    // val serviceImpl = ServiceLoader.load(Service::class.java)

    // java.util.ServiceLoader[java.security.Provider$Service]
    // println(serviceImpl)

    val serviceImpl2 = loadService<Service>()

    println(serviceImpl2)
}
