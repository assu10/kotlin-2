package com.assu.study.kotlin2me.chap07

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport

// PropertyChangeSupport 를 사용하기 위한 도우미 클래스 (이건 그대로 사용)
open class PropertyChangeAware2 {
    protected val changeSupport = PropertyChangeSupport(this)

    fun addPropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }
}

// 프로퍼티의 값을 저장하고 필요에 따라 통지를 보내주는 클래스
class ObservableProperty(
    val propName: String,
    var propValue: Int,
    val changeSupport: PropertyChangeSupport,
) {
    fun getValue(): Int = propValue

    fun setValue(newValue: Int) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(propName, oldValue, newValue)
    }
}

class People2(
    val name: String,
    age: Int,
    salary: Int,
) : PropertyChangeAware2() {
    val _age = ObservableProperty("age", age, changeSupport)
    var age: Int
        get() = _age.getValue()
        set(value) {
            _age.setValue(value)
        }

    val _salary = ObservableProperty("salary", salary, changeSupport)
    var salary: Int
        get() = _salary.getValue()
        set(value) {
            _salary.setValue(value)
        }
}

fun main() {
    val p = People2("Assu", 20, 100)

    // 프로퍼티 변경 리스터 추가
    p.addPropertyChangeListener { event ->
        println("Property ${event.propertyName} changed from ${event.oldValue} to ${event.newValue}")
    }

    p.age = 25 // Property age changed from 20 to 25
    p.salary = 200 // Property salary changed from 100 to 200
}
