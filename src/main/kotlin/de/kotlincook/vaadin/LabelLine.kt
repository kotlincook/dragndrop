package de.kotlincook.vaadin

import com.vaadin.flow.component.html.Label

class LabelLine : Line() {

    init {
        className += " label-line"
        val label = Label("")
        label.className = "label"
        label.text = "label text"
        add(label)
    }

}