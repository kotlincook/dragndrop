package de.kotlincook.vaadin

import com.vaadin.flow.component.textfield.TextArea

class TextAreaLine : Line() {

    init {
        className += " textarea-line"
        val textArea = TextArea()
        textArea.className = "textarea"
        textArea.value = "text area text"
        add(textArea)
    }

}