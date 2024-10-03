package com.assu.study.kotlin2me.chap07

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import kotlin.reflect.KProperty

// PropertyChangeSupport 를 사용하기 위한 도우미 클래스 (이건 그대로 사용)
open class PropertyChangeAware3 {
    protected val changeSupport = PropertyChangeSupport(this)

    fun addPropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }
}

// 프로퍼티의 값을 저장하고 필요에 따라 통지를 보내주는 클래스
// 위임 프로퍼티를 사용하기 위해 getValue(), setValue() 를 코틀린 관례에 맞게 수정
class ObservableProperty3(
    var propValue: Int,
    val changeSupport: PropertyChangeSupport,
) {
    operator fun getValue(
        p: People3,
        prop: KProperty<*>,
    ): Int = propValue

    operator fun setValue(
        p: People3,
        prop: KProperty<*>,
        newValue: Int,
    ) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }
}

class People3(
    val name: String,
    age: Int,
    salary: Int,
) : PropertyChangeAware3() {
    var age: Int by ObservableProperty3(age, changeSupport)
    var salary: Int by ObservableProperty3(salary, changeSupport)
}

fun main() {
    val p = People3("Assu", 20, 100)

    // 프로퍼티 변경 리스너 추가
    p.addPropertyChangeListener { event ->
        println("Property ${event.propertyName} changed from ${event.oldValue} to ${event.newValue}")
    }

    p.age = 25 // Property age changed from 20 to 25
    p.salary = 200 // Property salary changed from 100 to 200
}
