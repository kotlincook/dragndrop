package de.kotlincook.vaadin.bricksview.bricks

import com.vaadin.flow.component.textfield.TextArea

class TextAreaBrick : Brick() {

    init {
        className = "brick textarea-brick"
        val textArea = TextArea()
        textArea.className = "textarea"
        textArea.value = "text area text"
        add(textArea)
        add(Trash())
    }

}