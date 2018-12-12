package de.kotlincook.vaadin.bricksview.bricks

import com.vaadin.flow.component.ClickEvent
import com.vaadin.flow.component.textfield.TextArea
import com.vaadin.flow.data.binder.Binder
import de.kotlincook.vaadin.bricksview.BricksView
import de.kotlincook.vaadin.bricksview.Copy
import de.kotlincook.vaadin.bricksview.SelectArea
import de.kotlincook.vaadin.bricksview.Trash
import de.kotlincook.vaadin.vaadinutil.ancestor
import de.kotlincook.vaadin.viewmodel.TextFieldBean
import de.kotlincook.vaadin.viewmodel.ViewModel

class TextAreaBrick : Brick() {

    val textArea = TextArea().apply {
        className = "textarea"
        value = "Default text"
        label = "Label text"
    }

    val binder =  Binder(TextFieldBean::class.java).apply {
        forMemberField(textArea).bind("value")
    }

    init {
        className = "brick textarea-brick"
        add(textArea)
        add(Trash {
            ancestor(BricksView::class).delete(this)
        })
        add(Copy {
            ancestor(BricksView::class).double(this, this.clone())
        })
        addListener(ClickEvent::class.java) {
            binder.writeBean(ViewModel.textFieldBean)
            ViewModel.propertiesView.textFieldValueBinder.readBean(ViewModel.textFieldBean)
            select()
        }
        textArea.addValueChangeListener {
            // ViewModel.propertiesView.valueField.focus() // Krücke
            binder.writeBean(ViewModel.textFieldBean)
            ViewModel.propertiesView.textFieldValueBinder.readBean(ViewModel.textFieldBean)
        }
    }

    override fun clone(): TextAreaBrick {
       return TextAreaBrick()
    }

}