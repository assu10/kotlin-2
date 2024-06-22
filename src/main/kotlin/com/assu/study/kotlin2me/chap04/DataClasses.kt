package com.assu.study.kotlin2me.chap04

class Client(
    val name: String,
    val postalCode: Int,
) {
    override fun toString(): String = "Client(name='$name', postalCode=$postalCode)"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Client

        if (name != other.name) return false
        if (postalCode != other.postalCode) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + postalCode
        return result
    }
}

fun main() {
    val result1 = Client("AA", 123)

    // toString() 이 없을 경우: com.assu.study.kotlin2me.chap04.Client@41629346 이렇게 출력됨
    // toString() 이 있을 경우: Client(name='AA', postalCode=123)
    println(result1)

    val client1 = Client("BB", 111)
    val client2 = Client("BB", 111)
    println(client1 == client2) // false
}
