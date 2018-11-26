package de.kotlincook.vaadin

import com.vaadin.flow.component.UI
import com.vaadin.flow.component.html.Image

class PixelLine2() : Image("frontend/img/transparent1x1.png", "green1x1") {

    init {
        width = "100%"
        height = "2px"
//        className = "pixelline"

        UI.getCurrent().page.addDropSupport(element)
//        addListener(DropEvent::class.java, listener)

    }
}