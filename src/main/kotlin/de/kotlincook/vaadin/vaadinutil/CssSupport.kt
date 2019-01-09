package de.kotlincook.vaadin.vaadinutil

import com.vaadin.flow.component.Component
import com.vaadin.flow.component.HasStyle


fun Component.addCssClassRecursively(cssClass: String, filter: ((Component) -> Boolean)? = null) {
    if (this is HasStyle && (filter == null || filter(this))) {
        classNames.add(cssClass)
    }
    children.forEach { it.addCssClassRecursively(cssClass, filter) }
}

fun Component.removeCssClassRecursively(cssClass: String, filter: ((Component) -> Boolean)? = null) {
    if (this is HasStyle && (filter == null || filter(this))) {
        classNames.remove(cssClass)
    }
    children.forEach { it.removeCssClassRecursively(cssClass, filter) }
}

fun Component.switchCssClassRecursively(toRemove: String, toAdd: String, filter: ((Component) -> Boolean)? = null) {
    removeCssClassRecursively(toRemove, filter)
    addCssClassRecursively(toAdd, filter)
}