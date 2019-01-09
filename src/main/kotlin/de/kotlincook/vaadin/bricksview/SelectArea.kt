package de.kotlincook.vaadin.bricksview

import com.vaadin.flow.component.ClickEvent
import com.vaadin.flow.component.html.Image

class SelectArea(listener: (ClickEvent<*>) -> Unit) : Image("/frontend/img/transparent1x1.png", "transparent") {

    init {
        className = "select-area"
        addListener(ClickEvent::class.java, listener)
    }

}