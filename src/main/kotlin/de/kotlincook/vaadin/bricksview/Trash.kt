package de.kotlincook.vaadin.bricksview

import com.vaadin.flow.component.ClickEvent
import com.vaadin.flow.component.html.Image

class Trash(listener: (ClickEvent<*>) -> Unit) : Image("/frontend/img/trash.png", "trash") {

    init {
        className = "trash"
        addListener(ClickEvent::class.java, listener)
    }

}