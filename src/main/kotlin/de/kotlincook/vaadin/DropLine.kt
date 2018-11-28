package de.kotlincook.vaadin

import com.vaadin.flow.component.UI
import com.vaadin.flow.component.html.Image

class DropLine(width: String = "100%",
               thickness: String = "10px",
               dropAction: DropLine.(DropEvent<*>) -> Unit) : Image("frontend/img/transparent1x1.png", "green1x1") {

    init {
        this.width = width
        this.height = thickness
//        className = "pixelline"

        UI.getCurrent().page.addDropSupport(element)
        if (dropAction != null) {
            addListener(DropEvent::class.java, { e:DropEvent<*> -> dropAction(e)})
        }
    }
}