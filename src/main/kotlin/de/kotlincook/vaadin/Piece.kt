package de.kotlincook.vaadin

import com.vaadin.flow.component.*
import com.vaadin.flow.component.html.Image

@DomEvent("dragstart")
class DragstartEvent(source : Piece, fromClient : Boolean) : ComponentEvent<Piece>(source, fromClient)


class Piece(src: String, alt: String) : Image(src, alt) {

    init {
        className = "piece"
        setId(alt)

        // Drag & Drop:
        //
        UI.getCurrent().page.addDragSupport(element)
        addListener(DragstartEvent::class.java) {
            e -> println("Ich dragge gerade " + e.source)
        }
    }

}