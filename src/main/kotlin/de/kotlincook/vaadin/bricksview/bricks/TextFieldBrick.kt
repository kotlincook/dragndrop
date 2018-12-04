package de.kotlincook.vaadin.bricksview.bricks

import com.vaadin.flow.component.textfield.TextField

class TextFieldBrick : Brick() {

    init {
        className = "brick textfield-brick"
        val textField = TextField()
        textField.className = "textfield"
        textField.value = "text field value"
        add(textField)
        add(Trash())
    }

}