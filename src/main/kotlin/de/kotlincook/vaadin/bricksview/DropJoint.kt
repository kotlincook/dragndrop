package de.kotlincook.vaadin.bricksview

import com.vaadin.flow.component.UI
import com.vaadin.flow.component.html.Image
import de.kotlincook.vaadin.vaadinutil.DropEvent
import de.kotlincook.vaadin.vaadinutil.addDropSupport

class DropJoint(width: String = "100%",
                thickness: String = "15px",
                dropAction: DropJoint.(DropEvent<*>) -> Unit) : Image("frontend/img/transparent1x1.png", "transparent1x1") {

    init {
        this.width = width
        this.height = thickness

        UI.getCurrent().page.addDropSupport(element)
        if (dropAction != null) {
            addListener(DropEvent::class.java, { e: DropEvent<*> -> dropAction(e)})
        }
    }
}