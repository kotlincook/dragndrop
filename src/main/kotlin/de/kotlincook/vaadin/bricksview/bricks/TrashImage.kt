package de.kotlincook.vaadin.bricksview.bricks

import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.html.Image

class TrashImage : Button() {

    init {
        val image = Image("/frontend/img/trash.png", "trash")
        image.className = "trash"
        className = "trash"
        icon = image
        addClickListener { println("Hallo") }
    }

}