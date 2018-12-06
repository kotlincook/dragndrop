package de.kotlincook.vaadin.bricksview.bricks

import com.vaadin.flow.component.ClickEvent
import com.vaadin.flow.component.html.Image
import de.kotlincook.vaadin.vaadinutil.Selectable
import java.util.NoSuchElementException

class SelectArea : Image("/frontend/img/transparent1x1.png", "transparent") {

    init {
        className = "select-area"
        addListener(ClickEvent::class.java) {
            if (!parent.isPresent) return@addListener
            val parentComp = parent.get()
            if (parentComp is Selectable) parentComp.select()
        }
    }

}