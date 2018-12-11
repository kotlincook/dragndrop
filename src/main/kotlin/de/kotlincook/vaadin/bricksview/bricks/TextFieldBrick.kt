package de.kotlincook.vaadin.bricksview.bricks

import com.vaadin.flow.component.ClickEvent
import com.vaadin.flow.component.Key
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

    val textField = TextField().apply {
        className = "textfield"
        value = "text field valueField"
    }
    val binder =  Binder(TextfieldBean::class.java).apply {
        forMemberField(textField).bind("value")
    }

    init {
        className = "brick textfield-brick"
        add(textField)

        add(Trash {
            ancestor(BricksView::class).delete(this)
        })
        add(Copy {
            ancestor(BricksView::class).double(this, this.clone())
        })
        addListener(ClickEvent::class.java) {
            binder.writeBean(SafeModel.bindingBean)
            SafeModel.propertiesView.binder.readBean(SafeModel.bindingBean)
            select()
        }
        textField.addValueChangeListener {
            println("Ich bin neikommet")
            SafeModel.propertiesView.valueField.focus() // Krücke
            binder.writeBean(SafeModel.bindingBean)
            SafeModel.propertiesView.binder.readBean(SafeModel.bindingBean)
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