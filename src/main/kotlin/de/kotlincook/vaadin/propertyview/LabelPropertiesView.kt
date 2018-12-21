package de.kotlincook.vaadin.propertyview

import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.component.textfield.TextField
import com.vaadin.flow.data.binder.Binder
import de.kotlincook.vaadin.bricksview.bricks.TextAreaBrick
import de.kotlincook.vaadin.bricksview.bricks.TextFieldBrick
import de.kotlincook.vaadin.viewmodel.ViewModel
import de.kotlincook.vaadin.viewmodel.TextFieldBean

class LabelPropertiesView : VerticalLayout() {

    val textField = TextField("Value")

    val textFieldValueBinder = Binder(TextFieldBean::class.java).apply {
        forMemberField(textField).bind("value")
        bean = ViewModel.textFieldBean
    }

    init {
        isSpacing = false
        add(textField)

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