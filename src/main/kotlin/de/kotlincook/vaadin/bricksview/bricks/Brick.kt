package de.kotlincook.vaadin.bricksview.bricks

import com.vaadin.flow.component.Component
import com.vaadin.flow.component.HasStyle
import com.vaadin.flow.component.UI
import com.vaadin.flow.component.html.Div
import de.kotlincook.vaadin.vaadinutil.DragstartEvent
import de.kotlincook.vaadin.vaadinutil.addDragSupport
import de.kotlincook.vaadin.vaadinutil.pushDraggedComponent

abstract class Brick : Div() {

    init {
        UI.getCurrent().page.addDragSupport(element)
        addListener(DragstartEvent::class.java) { e ->
            pushDraggedComponent(e.source)
        }
    }
}


fun Component.select(on: Boolean) {
    println(this::class.java)
    if (this is HasStyle) {
        classNames.set(".brick.selected", on)
    }
    children.forEach { it.select(on) }
}