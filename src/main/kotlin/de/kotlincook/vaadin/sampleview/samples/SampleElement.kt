package de.kotlincook.vaadin.sampleview.samples

import com.vaadin.flow.component.*
import com.vaadin.flow.component.html.Div
import de.kotlincook.vaadin.vaadinutil.DragstartEvent
import de.kotlincook.vaadin.vaadinutil.addDragSupport
import de.kotlincook.vaadin.vaadinutil.pushDraggedComponent

abstract class SampleElement : Div() {

    init {
        className = "sample-element"

        UI.getCurrent().page.addDragSupport(element)
        addListener(DragstartEvent::class.java) { e ->
            pushDraggedComponent(e.source)
        }
    }
}