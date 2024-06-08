package com.assu.study.kotlin2me.chap03

fun main() {
    val str =
        """|  //
                .| //
                .|/\
        """

    //  //
    //                .| //
    //                .|/\
    println(str.trimMargin())

    // |  //
    // | //
    // |/\
    println(str.trimMargin("."))

    // |  //
    // //
    // /\
    println(str.trimMargin(".|"))

    val price = """${'$'}9.99"""
    println(price) // $9.99
}
