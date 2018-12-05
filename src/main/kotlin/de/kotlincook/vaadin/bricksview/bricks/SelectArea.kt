package de.kotlincook.vaadin.bricksview.bricks

import com.vaadin.flow.component.ClickEvent
import com.vaadin.flow.component.HasStyle
import com.vaadin.flow.component.html.Image

class SelectArea : Image("/frontend/img/transparent1x1.png", "transparent") {

    init {
        className = "select-area"
        addListener(ClickEvent::class.java) {
            classNames.add("brick-selected")
            (parent.get() as HasStyle).classNames.add("gucken")
////            removeClassName("brick")
////            addClassName("brick-selected")
            if (parent.isPresent) parent.get().select(true)
        }
    }

}