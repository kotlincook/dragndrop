package de.kotlincook.vaadin

import com.vaadin.flow.component.ComponentEvent
import com.vaadin.flow.component.DomEvent
import com.vaadin.flow.component.UI
import com.vaadin.flow.component.html.Div

@DomEvent("drop")
class DropEvent(source: Square, fromClient: Boolean) : ComponentEvent<Square>(source, fromClient)

class Square() : Div() {

    init {
        setId("square")
        className = "square black"

        // Drag & Drop:
        //
        UI.getCurrent().page.addDropSupport(element)
        addListener(DropEvent::class.java) { e ->
            println("Ich droppe gerade " + e.source)
        }
    }

}