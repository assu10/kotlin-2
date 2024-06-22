package com.assu.study.kotlin2me.chap04

fun getFacebookName1(id: Int) = "A::$id"

class User1 private constructor(
    val nickname: String,
) { // 주생성자를 private 로 만듬
    // 동반 객체 선언
    companion object {
        fun newEmailUser(email: String) = User1(email.substringBefore('@'))

        fun newFacebookUser(facebookAccountId: Int) = User1(getFacebookName1(1))
    }
}

fun main() {
    val user1 = User1.newEmailUser("assu1@naver.com")
    val user2 = User1.newFacebookUser(1)

    println(user1.nickname) // assu1
    println(user2.nickname) // A::1
}
