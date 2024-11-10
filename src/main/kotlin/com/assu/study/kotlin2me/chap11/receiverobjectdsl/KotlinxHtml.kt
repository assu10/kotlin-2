package com.assu.study.kotlin2me.chap11.receiverobjectdsl

import kotlinx.html.dom.createHTMLTree
import kotlinx.html.dom.document
import kotlinx.html.dom.serialize
import kotlinx.html.table
import kotlinx.html.td
import kotlinx.html.tr

fun createTable() =
    document { }.createHTMLTree()
        .table { // this 는 TABLE
            tr { // this 는 TR
                td { // this 는 TD
                    +"cell"
                }
            }
        }

fun main() {
    println(createTable().serialize())
}