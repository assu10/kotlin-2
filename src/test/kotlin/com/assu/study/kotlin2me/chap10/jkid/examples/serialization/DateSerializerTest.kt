package com.assu.study.kotlin2me.chap10.jkid.examples.serialization

import ru.yole.jkid.CustomSerializer
import ru.yole.jkid.ValueSerializer
import ru.yole.jkid.deserialization.deserialize
import ru.yole.jkid.serialization.serialize
import java.text.SimpleDateFormat
import java.util.Date
import kotlin.test.Test
import kotlin.test.assertEquals

object DateSerializer : ValueSerializer<Date> {
    private val dateFormat = SimpleDateFormat("dd-mm-yyyy")

    override fun toJsonValue(value: Date): Any? = dateFormat.format(value)

    override fun fromJsonValue(jsonValue: Any?): Date = dateFormat.parse(jsonValue as String)
}

data class Person5(
    val name: String,
    @CustomSerializer(DateSerializer::class)
    val birthDate: Date,
)

inline fun <reified T : Any> testJsonSerializer2(
    value: T,
    json: String,
) {
    assertEquals(json, serialize(value))
    assertEquals(value, deserialize(json))
}

class DateSerializerTest {
    @Test
    fun test() {
        testJsonSerializer2(
            value = Person5("Assu", SimpleDateFormat("dd-mm-yyyy").parse("01-10-1984")),
            json = """{"birthDate": "01-10-1984", "name": "Assu"}""",
        )
    }
}
