package com.assu.study.kotlin2me.chap10.jkid.examples

import org.junit.jupiter.api.Test
import ru.yole.jkid.JsonExclude
import ru.yole.jkid.JsonName
import ru.yole.jkid.deserialization.deserialize
import ru.yole.jkid.serialization.serialize
import kotlin.test.assertEquals

data class Person(
    val name: String,
    val age: Int,
)

data class Person2(
    @JsonName("alias")
    val firstName: String,
    @JsonExclude
    val age: Int? = null,
)

class PersonTest {
    @Test
    fun test() {
        val person = Person("Alice", 29)
        val json = """{"age": 29, "name": "Alice"}"""

        // {"age": 29, "name": "Alice"}
        println(serialize(person))

        // JSON 에는 객체의 타입이 저장되지 않으므로 JSON 으로부터 인스턴스를 만들려면 타입 인자로
        // 클래스를 명시해야 함 (아래에서는 Person 클래스를 타입 인자로 넘김)
        // Person(name=Alice, age=29)
        println(deserialize<Person>(json))

        assertEquals(json, serialize(person))
        assertEquals(person, deserialize(json))
    }

    @Test
    fun test2() {
        val person2 = Person2("Lee", 20)
        val json = """{"alias": "Lee"}"""
        val json2 = """{"alias": "Lee", "age": 20}"""

        // {"alias": "Lee"}
        println(serialize(person2))

        // Person2(firstName=Lee, age=null)
        println(deserialize<Person2>(json))

        assertEquals(json, serialize(person2))
        assertEquals(person2, deserialize(json2))
    }
}
