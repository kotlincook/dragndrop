package de.kotlincook.vaadin

import com.vaadin.flow.component.*
import com.vaadin.flow.component.html.Div
import com.vaadin.flow.component.html.Image
import com.vaadin.flow.component.html.Label
import com.vaadin.flow.component.orderedlayout.HorizontalLayout

abstract class SampleElement : Div() {

    init {
        className = "sample-element"

        UI.getCurrent().page.addDragSupport(element)
        addListener(DragstartEvent::class.java) {
            e -> pushDraggedComponent(e.source)
        }
    }
}