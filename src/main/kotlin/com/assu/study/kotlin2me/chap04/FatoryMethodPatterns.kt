package com.assu.study.kotlin2me.chap04

class User {
    val nickname: String

    // 부생성자
    constructor(email: String) {
        nickname = email.substringBefore('@')
    }

    // 부생성자
    constructor(facebookAccountId: Int) {
        nickname = getFacebookName(facebookAccountId)
    }
}

fun getFacebookName(id: Int) = "A::$id"

fun main() {
    val user1 = User("assu1@naver.com")
    val user2 = User(1)

    println(user1.nickname) // assu1
    println(user2.nickname) // A::1
}
