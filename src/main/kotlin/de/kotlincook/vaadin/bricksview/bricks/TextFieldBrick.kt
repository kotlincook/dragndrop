package de.kotlincook.vaadin.bricksview.bricks

import com.vaadin.flow.component.ClickEvent
import com.vaadin.flow.component.html.Div
import com.vaadin.flow.component.html.Label
import com.vaadin.flow.component.textfield.TextField
import com.vaadin.flow.data.binder.Binder
import de.kotlincook.vaadin.bricksview.BricksView
import de.kotlincook.vaadin.propertyview.TextFieldPropertiesView
import de.kotlincook.vaadin.vaadinutil.BindableLabel
import de.kotlincook.vaadin.viewmodel.ViewModel
import de.kotlincook.vaadin.viewmodel.TextFieldBean
import de.kotlincook.vaadin.vaadinutil.ancestor
import de.kotlincook.vaadin.vaadinutil.descendants

class TextFieldBrick : Brick() {

    val textField = TextField().apply {
        className = "textfield"
        value = "Default text"
    }

    val textFieldLabel = BindableLabel().apply {
        className = "textfield-label cursor-grabbing"
        value = "Label text"
    }

    val labelFieldPair = Div().apply {
        className = "label-field-pair"
        add(textFieldLabel)
        add(textField)
    }

    val controlGroup = ControlGroup(
            { ancestor(BricksView::class).double(this, this.clone()) },
            { ancestor(BricksView::class).delete(this) })

    val binder =  Binder(TextFieldBean::class.java).apply {
        forMemberField(textField).bind("value")
        forMemberField(textFieldLabel).bind("label")
    }

    init {
        className = "brick textfield-brick"
        add(labelFieldPair)
        add(controlGroup)

        addListener(ClickEvent::class.java) {
            binder.writeBean(ViewModel.textFieldBean)
//            ViewModel.propertiesView = TextFieldPropertiesView()
            ViewModel.propertiesView.propertiesBinder.readBean(ViewModel.textFieldBean)
            select()
            textField.addValueChangeListener {
                binder.writeBean(ViewModel.textFieldBean)
                ViewModel.propertiesView.propertiesBinder.readBean(ViewModel.textFieldBean)
            }
        }

    }

    // https://vaadin.com/blog/vaadin-8-binder

    override fun clone(): TextFieldBrick {
        val clone = TextFieldBrick()
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