package de.kotlincook.vaadin.vaadinutil

import com.vaadin.flow.component.Component
import com.vaadin.flow.component.HasStyle


fun Component.addCssClassRecursivly(cssClass: String) {
//    println(this::class.java)
    if (this is HasStyle) {
        classNames.add(cssClass)
    }
    children.forEach { it.addCssClassRecursivly(cssClass) }
}

fun Component.removeCssClassRecursivly(cssClass: String) {
//    println(this::class.java)
    if (this is HasStyle) {
        classNames.remove(cssClass)
    }
    children.forEach { it.removeCssClassRecursivly(cssClass) }
}

fun Component.switchCssClassRecursivly(toRemove: String, toAdd: String) {
//    println(this::class.java)
    removeCssClassRecursivly(toRemove)
    addCssClassRecursivly(toAdd)
}