package de.kotlincook.vaadin.bricksview.bricks

import com.vaadin.flow.component.ClickEvent
import com.vaadin.flow.component.html.Label
import de.kotlincook.vaadin.bricksview.BricksView
import de.kotlincook.vaadin.vaadinutil.ancestor

class LabelBrick : Brick() {

    val label = Label("").apply {
        className = "label"
        text = "Label text"
    }

    val controlGroup = ControlGroup(
            { ancestor(BricksView::class).double(this, this.clone()) },
            { ancestor(BricksView::class).delete(this) })

    init {
        className = "brick label-brick"
        add(label)
        add(controlGroup)

        addListener(ClickEvent::class.java) {
            select()
        }
    }

    override fun clone(): LabelBrick {
        return LabelBrick()
    }

}