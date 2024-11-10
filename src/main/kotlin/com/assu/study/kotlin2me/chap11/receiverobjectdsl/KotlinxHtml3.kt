package com.assu.study.kotlin2me.chap11.receiverobjectdsl

import kotlinx.html.DIV
import kotlinx.html.UL
import kotlinx.html.a
import kotlinx.html.classes
import kotlinx.html.li
import kotlinx.html.role
import kotlinx.html.ul

// 1)
fun UL.item(href: String, name: String): Unit = li { a(href) { +name } }

// 2)
fun UL.divider(): Unit = li { role = "separator"; classes = setOf("divider") }

// 3)
fun UL.dropdownHeader(text: String): Unit = li { classes = setOf("dropdown-header"); +text }

// 4)
fun DIV.dropdownMenu(block: UL.() -> Unit): Unit = ul("dropdown-menu", block)

// 5)
//fun StringBuilder.dropdown(block: DIV.() -> Unit): String = div("dropdown", block)