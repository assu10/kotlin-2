package com.assu.study.kotlin2me.chap11.exposed

import org.jetbrains.exposed.sql.Table

object Country: Table() {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 50)
    override val primaryKey = PrimaryKey(id, name="PK_id")
}



