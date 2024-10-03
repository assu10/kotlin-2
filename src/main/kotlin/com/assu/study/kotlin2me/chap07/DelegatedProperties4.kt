package com.assu.study.kotlin2me.chap07

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

// PropertyChangeSupport 를 사용하기 위한 도우미 클래스 (이건 그대로 사용)
open class PropertyChangeAware4 {
    protected val changeSupport = PropertyChangeSupport(this)

    fun addPropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }
}

// 위임 프로퍼티 `by` 와 `Delegates.observable()` 사용
class People4(
    val name: String,
    age: Int,
    salary: Int,
) : PropertyChangeAware4() {
    private val observer = { prop: KProperty<*>, oldValue: Int, newValue: Int ->
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }

    var age: Int by Delegates.observable(age, observer)
    var salary: Int by Delegates.observable(salary, observer)
}

fun main() {
    val p = People4("Assu", 20, 100)

    // 프로퍼티 변경 리스너 추가
    p.addPropertyChangeListener { event ->
        println("Property ${event.propertyName} changed from ${event.oldValue} to ${event.newValue}")
    }

    p.age = 25 // Property age changed from 20 to 25
    p.salary = 200 // Property salary changed from 100 to 200
}
