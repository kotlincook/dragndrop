package de.kotlincook.vaadin.propertyview

import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.component.textfield.TextField
import com.vaadin.flow.data.binder.Binder
import de.kotlincook.vaadin.bricksview.bricks.TextAreaBrick
import de.kotlincook.vaadin.bricksview.bricks.TextFieldBrick
import de.kotlincook.vaadin.viewmodel.ViewModel
import de.kotlincook.vaadin.viewmodel.TextFieldBean

class PropertiesView : VerticalLayout() {

    val labelField = TextField("Label")
    val valueField = TextField("Value")

    val textFieldValueBinder = Binder(TextFieldBean::class.java).apply {
        forMemberField(valueField).bind("value")
        forMemberField(labelField).bind("label")
        bean = ViewModel.textFieldBean
    }

    init {
        isSpacing = false
        add(labelField)
        add(valueField)

        textFieldValueBinder.addValueChangeListener {
            textFieldValueBinder.writeBean(ViewModel.textFieldBean)
            val selectedBrick = ViewModel.selectedBrick()
            when (selectedBrick) {
                is TextFieldBrick -> selectedBrick.binder.readBean(ViewModel.textFieldBean)
                is TextAreaBrick -> selectedBrick.binder.readBean(ViewModel.textFieldBean)
            }
        }
    }
}