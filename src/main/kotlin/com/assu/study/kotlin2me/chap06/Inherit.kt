package com.assu.study.kotlin2me.chap06

class KtClass1 : JavaInterface {
    override fun action(input: String) {
        println(input)
    }
}

class KtClass2 : JavaInterface {
    override fun action(input: String?) {
        if (input != null) {
            println(input)
        }
    }
}
