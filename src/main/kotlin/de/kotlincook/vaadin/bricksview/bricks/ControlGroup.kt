package de.kotlincook.vaadin.bricksview.bricks

import com.vaadin.flow.component.ClickEvent
import com.vaadin.flow.component.html.Div
import de.kotlincook.vaadin.bricksview.Copy
import de.kotlincook.vaadin.bricksview.Trash

class ControlGroup(copyListener: (ClickEvent<*>) -> Unit,
                   deleteListener: (ClickEvent<*>) -> Unit) : Div() {

    init {
        className = "control-group"
        add(Trash(deleteListener))
        add(Copy(copyListener))
    }
}