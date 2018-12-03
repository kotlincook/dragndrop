package de.kotlincook.vaadin.bricksview.bricks

import com.vaadin.flow.component.html.Image
import com.vaadin.flow.component.html.Label

class LabelBrick : Brick() {

    init {
        className += " label-brick"
        val label = Label("")
        label.className = "label"
        label.text = "label text"
        add(label)
        add(TrashImage())
    }

}