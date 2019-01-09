package de.kotlincook.vaadin.bricksview

import com.vaadin.flow.component.ClickEvent
import com.vaadin.flow.component.html.Image

class Copy(listener: (ClickEvent<*>) -> Unit) : Image("/frontend/img/copy.png", "copy") {

    init {
        className = "copy"
        addListener(ClickEvent::class.java, listener)
    }

}