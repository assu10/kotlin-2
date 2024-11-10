package com.assu.study.kotlin2me.chap11.receiverobjectdsl

import kotlinx.html.a
import kotlinx.html.button
import kotlinx.html.classes
import kotlinx.html.div
import kotlinx.html.li
import kotlinx.html.role
import kotlinx.html.span
import kotlinx.html.stream.createHTML
import kotlinx.html.ul

fun buildDropdown() = createHTML().div(classes = "dropdown") { // 5) , this 는 DIV
    button(classes = "btn dropdown-toggle") { // this 는 BUTTON
        +"Dropdown"
        span(classes = "caret")
    }
    ul(classes = "dropdown-menu") { // 4), this 는 UL
        li { a("#") { +"Action" } } // 1)
        li { a("#") { +"Another Action" } }
        li { role = "separator"; classes = setOf("divider") } // 2)
        li { classes = setOf("dropdown-header"); +"Header" } // 3)
        li { a("#") { +"Separated link" } }
    }
}

fun main() {
    println(buildDropdown())
}
