package de.kotlincook.vaadin

import com.vaadin.flow.component.textfield.TextField

class TextFieldLine : Line() {

    init {
        className += " textfield-line"
        val textField = TextField()
        textField.className = "textfield"
        textField.value = "text field value"
        add(textField)
    }

}