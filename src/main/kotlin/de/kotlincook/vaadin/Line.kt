package de.kotlincook.vaadin

import com.vaadin.flow.component.UI
import com.vaadin.flow.component.html.Div

class Line : Div() {

    init {
        className = "line black"
        UI.getCurrent().page.addDropSupport(element)
        addListener(DropEvent::class.java) { e ->
            println("Ich droppe gerade " + e.source)
        }
    }

}