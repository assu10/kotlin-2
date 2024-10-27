package com.assu.study.kotlin2me.chap10.jkid.examples

import ru.yole.jkid.DeserializeInterface
import ru.yole.jkid.deserialization.deserialize
import ru.yole.jkid.serialization.serialize
import kotlin.test.Test
import kotlin.test.assertEquals

interface Company {
    val name: String
}

data class CompanyImpl(
    override val name: String,
) : Company

data class Person3(
    val name: String,
    @DeserializeInterface(CompanyImpl::class)
    val company: Company,
)

inline fun <reified T : Any> testJsonSerializer(
    value: T,
    json: String,
) {
    assertEquals(json, serialize(value))
    assertEquals(value, deserialize(json))
}

class DeserializeInterfaceTest {
    @Test
    fun test() {
        testJsonSerializer(
            value = Person3("Assu", CompanyImpl("Silby")),
            json = """{"company": {"name": "Silby"}, "name": "Assu"}""",
        )
    }
}
