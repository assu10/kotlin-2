package com.assu.study.kotlin2me.chap08

enum class Delivery { STANDARD, EXPENDED }

data class Order(
    val itemCount: Int,
)

// 함수를 반환하는 함수를 선언 (Order 를 받아서 Double 을 반환하는 함수를 반환)
fun getShippingCostCalculator(delivery: Delivery): (Order) -> Double {
    if (delivery == Delivery.EXPENDED) {
        return { order -> order.itemCount * 3.0 }
    }

    // 함수에서 람다를 반환
    return { order -> order.itemCount * 2.0 }
}

fun main() {
    // 반환받은 함수를 변수에 저장
    val calculator = getShippingCostCalculator(Delivery.EXPENDED)

    // 반환받은 함수 호출

    // cost: 9.0
    println("cost: ${calculator(Order(3))}")
}
