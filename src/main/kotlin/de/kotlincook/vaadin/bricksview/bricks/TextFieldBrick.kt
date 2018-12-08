package de.kotlincook.vaadin.bricksview.bricks

import com.vaadin.flow.component.textfield.TextField
import de.kotlincook.vaadin.bricksview.BricksView
import de.kotlincook.vaadin.bricksview.Copy
import de.kotlincook.vaadin.bricksview.SelectArea
import de.kotlincook.vaadin.bricksview.Trash
import de.kotlincook.vaadin.vaadinutil.ancestor

class TextFieldBrick : Brick() {

    init {
        className = "brick textfield-brick"
        val textField = TextField()
        textField.className = "textfield"
        textField.value = "text field value"
        add(textField)
        add(Trash {
            ancestor(BricksView::class).delete(this)
        })
        add(Copy {
            ancestor(BricksView::class).double(this, this.clone())
        })
        add(SelectArea {
            select()
        })
    }

    override fun clone(): TextFieldBrick {
        return TextFieldBrick()
    }

}