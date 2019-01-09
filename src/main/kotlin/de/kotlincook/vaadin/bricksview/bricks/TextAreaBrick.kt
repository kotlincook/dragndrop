package de.kotlincook.vaadin.bricksview.bricks

import com.vaadin.flow.component.ClickEvent
import com.vaadin.flow.component.html.Div
import com.vaadin.flow.component.html.Label
import com.vaadin.flow.component.textfield.TextArea
import com.vaadin.flow.component.textfield.TextField
import com.vaadin.flow.data.binder.Binder
import de.kotlincook.vaadin.bricksview.BricksView
import de.kotlincook.vaadin.vaadinutil.BindableLabel
import de.kotlincook.vaadin.vaadinutil.ancestor
import de.kotlincook.vaadin.vaadinutil.descendants
import de.kotlincook.vaadin.viewmodel.TextFieldBean
import de.kotlincook.vaadin.viewmodel.ViewModel

class TextAreaBrick : Brick() {

    val textArea = TextArea().apply {
        className = "textarea"
        value = "Default text"
    }

    val textAreaLabel = BindableLabel().apply {
        className = "textarea-label cursor-grabbing"
        value = "Label text"
    }

    val labelFieldPair = Div().apply {
        className = "label-field-pair"
        add(textAreaLabel)
        add(textArea)
    }

    val controlGroup = ControlGroup(
            { ancestor(BricksView::class).double(this, this.clone()) },
            { ancestor(BricksView::class).delete(this) })

    val binder =  Binder(TextFieldBean::class.java).apply {
        forMemberField(textArea).bind("value")
        forMemberField(textAreaLabel).bind("label")
    }

    init {
        className = "brick textarea-brick"
        add(labelFieldPair)
        add(controlGroup)

        addListener(ClickEvent::class.java) {
            binder.writeBean(ViewModel.textFieldBean)
            ViewModel.propertiesView.propertiesBinder.readBean(ViewModel.textFieldBean)
            select()
        }
        textArea.addValueChangeListener {
            binder.writeBean(ViewModel.textFieldBean)
            ViewModel.propertiesView.propertiesBinder.readBean(ViewModel.textFieldBean)
        }
    }

    override fun clone(): TextAreaBrick {
        val clone = TextAreaBrick()
        val zip = descendants().zip(clone.descendants())
        for ((source, dest) in zip) {
            when {
                source is TextField && dest is TextField -> dest.value = source.value
                source is Label && dest is Label -> dest.text = source.text
            }
        }
        return clone
    }

}