package de.kotlincook.vaadin.bricksview.bricks

import com.vaadin.flow.component.ClickEvent
import com.vaadin.flow.component.html.Image
import de.kotlincook.vaadin.model.SafeModel

class Trash : Image("/frontend/img/trash.png", "trash") {

    init {
        className = "trash"
        addListener(ClickEvent::class.java) {
            SafeModel.bricksView.delete(parent.get())
        }
    }

}