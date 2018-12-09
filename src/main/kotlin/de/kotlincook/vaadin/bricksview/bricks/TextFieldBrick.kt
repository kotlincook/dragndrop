package de.kotlincook.vaadin.bricksview.bricks

import com.vaadin.flow.component.ClickEvent
import com.vaadin.flow.component.textfield.TextField
import com.vaadin.flow.data.binder.Binder
import com.vaadin.flow.data.binder.PropertyId
import de.kotlincook.vaadin.bricksview.BricksView
import de.kotlincook.vaadin.bricksview.Copy
import de.kotlincook.vaadin.bricksview.Trash
import de.kotlincook.vaadin.model.SafeModel
import de.kotlincook.vaadin.model.TextfieldBean
import de.kotlincook.vaadin.vaadinutil.ancestor
import kotlin.streams.toList

class TextFieldBrick : Brick() {

    @PropertyId("value")
    val textField = TextField()

    init {
        className = "brick textfield-brick"
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
            val binder =  Binder(TextfieldBean::class.java)
            binder.forMemberField(textField)
            binder.bindInstanceFields(this)
            binder.bean = SafeModel.bindingBean
        }
    }

    // https://vaadin.com/blog/vaadin-8-binder

    override fun clone(): TextFieldBrick {
        val clone = TextFieldBrick()
        val zip = children.toList().zip(clone.children.toList())
        for ((source, dest) in zip) {
            when {
                source is TextField && dest is TextField -> dest.value = source.value
            }
        }
        return clone
    }

}