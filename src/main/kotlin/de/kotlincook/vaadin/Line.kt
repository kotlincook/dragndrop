package de.kotlincook.vaadin

import com.vaadin.flow.component.UI
import com.vaadin.flow.component.html.Div
import com.vaadin.flow.component.html.Image
import com.vaadin.flow.component.html.Label
import com.vaadin.flow.component.textfield.TextField

class Line : Div() {

    init {
        className = "line black"
//        val image = Image("frontend/img/green1x1.png", "green1x1")
//        image.width = "20px"
//        image.height = "100%"
        val textField = TextField()
        textField.className = "textfield"
        textField.value = "Hast Du das gesehen?"
        add(textField)
        UI.getCurrent().page.addDragSupport(element)
        addListener(DragstartEvent::class.java) { e ->
            pushDraggedComponent(e.source)
            println("Ich dragge gerade " + e.source)
        }
    }

}