package com.assu.study.kotlin2me.chap06

fun sendToEmail(email: String) = println("Sending email to $email")

fun main() {
    val email1: String? = "assu@test.com"

    // Sending email to assu@test.com
    email1?.let { sendToEmail(it) }

    val email2: String? = null

    // 아무일도 일어나지 않음
    email2?.let { sendToEmail(it) }
}