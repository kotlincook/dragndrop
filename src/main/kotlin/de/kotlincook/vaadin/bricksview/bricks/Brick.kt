package de.kotlincook.vaadin.bricksview.bricks

import com.vaadin.flow.component.UI
import com.vaadin.flow.component.html.Div
import de.kotlincook.vaadin.vaadinutil.DragstartEvent
import de.kotlincook.vaadin.vaadinutil.Selectable
import de.kotlincook.vaadin.vaadinutil.addDragSupport
import de.kotlincook.vaadin.vaadinutil.pushDraggedComponent

abstract class Brick : Div(), Selectable {

    init {
        UI.getCurrent().page.addDragSupport(element)
        addListener(DragstartEvent::class.java) { e ->
            pushDraggedComponent(e.source)
        }
    }
}

