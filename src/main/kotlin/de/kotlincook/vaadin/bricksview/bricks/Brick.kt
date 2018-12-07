package de.kotlincook.vaadin.bricksview.bricks

import com.vaadin.flow.component.UI
import com.vaadin.flow.component.html.Div
import de.kotlincook.vaadin.bricksview.BricksView
import de.kotlincook.vaadin.bricksview.DropJoint
import de.kotlincook.vaadin.vaadinutil.*

abstract class Brick : Div() {

    init {
        UI.getCurrent().page.addDragSupport(element)
        addListener(DragstartEvent::class.java) { e ->
            pushDraggedComponent(e.source)
        }
    }

    fun select() {
        ancestor(BricksView::class).switchCssClassRecursively("brick-selected", "brick-nonSelected") {
            it !is DropJoint && it !is BricksView
        }
        ancestor(this::class).switchCssClassRecursively("brick-nonSelected", "brick-selected")
    }
}

