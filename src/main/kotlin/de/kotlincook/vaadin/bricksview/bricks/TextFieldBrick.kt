package de.kotlincook.vaadin.bricksview.bricks

import com.vaadin.flow.component.ClickEvent
import com.vaadin.flow.component.textfield.TextField
import de.kotlincook.vaadin.bricksview.BricksView
import de.kotlincook.vaadin.bricksview.Copy
import de.kotlincook.vaadin.bricksview.Trash
import de.kotlincook.vaadin.vaadinutil.ancestor
import kotlin.streams.toList

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
        addListener(ClickEvent::class.java) {
            select()
        }
    }

    override fun clone(): TextFieldBrick {
        val clone = TextFieldBrick()
        val zip = children.toList().zip(clone.children.toList())
        for ((source, dest) in zip) {
            when {
                source is TextField && dest is TextField ->
                    dest.value = source.value
            }
        }
        return clone
    }

}