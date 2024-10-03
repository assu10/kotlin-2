package com.assu.study.kotlin2me.chap07

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport

// PropertyChangeSupport 를 사용하기 위한 도우미 클래스
open class PropertyChangeAware {
    protected val changeSupport = PropertyChangeSupport(this)

    fun addPropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }
}

// 프로퍼티 변경 통지를 직접 구현
class People(
    val name: String, // public final val name: String
    age: Int, // value-parameter val age: Int
    salary: Int,
) : PropertyChangeAware() {
    var age: Int = age
        set(newValue) {
            // field 를 사용하여 age 프로퍼티의 backing field 에 접근
            val oldValue = field
            field = newValue

            // 프로퍼티 변경을 리스너에게 통지
            changeSupport.firePropertyChange("age", oldValue, newValue)
        }

    var salary: Int = salary
        set(newValue) {
            val oldValue = field
            field = newValue
            changeSupport.firePropertyChange("salary", oldValue, newValue)
        }
}

fun main() {
    val p = People("Assu", 20, 100)

    // 프로퍼티 변경 리스너 추가
    p.addPropertyChangeListener { event ->
        println("Property ${event.propertyName} changed from ${event.oldValue} to ${event.newValue}")
    }

    p.age = 25 // Property age changed from 20 to 25
    p.salary = 200 // Property salary changed from 100 to 200
}
