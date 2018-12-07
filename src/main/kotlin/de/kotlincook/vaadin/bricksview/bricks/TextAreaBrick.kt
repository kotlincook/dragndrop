package de.kotlincook.vaadin.bricksview.bricks

import com.vaadin.flow.component.textfield.TextArea
import de.kotlincook.vaadin.bricksview.BricksView
import de.kotlincook.vaadin.bricksview.SelectArea
import de.kotlincook.vaadin.bricksview.Trash
import de.kotlincook.vaadin.vaadinutil.ancestor

class TextAreaBrick : Brick() {

    init {
        className = "brick textarea-brick"
        val textArea = TextArea()
        textArea.className = "textarea"
        textArea.value = "text area text"
        add(textArea)
        add(Trash {
            ancestor(BricksView::class).delete(this)
        })
        add(SelectArea {
            select()
        })
    }

}