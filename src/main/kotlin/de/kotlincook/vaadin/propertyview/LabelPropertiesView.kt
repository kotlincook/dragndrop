package de.kotlincook.vaadin.propertyview

import com.vaadin.flow.component.textfield.TextField
import com.vaadin.flow.data.binder.Binder
import de.kotlincook.vaadin.bricksview.bricks.TextAreaBrick
import de.kotlincook.vaadin.bricksview.bricks.TextFieldBrick
import de.kotlincook.vaadin.viewmodel.TextFieldBean
import de.kotlincook.vaadin.viewmodel.ViewModel

class LabelPropertiesView : PropertiesView() {

    val textField = TextField("Value")

    override val propertiesBinder = Binder<TextFieldBean>().apply {
        forMemberField(textField).bind("value")
        bean = ViewModel.textFieldBean
    }

    init {
        isSpacing = false
        add(textField)

        propertiesBinder.addValueChangeListener {
            propertiesBinder.writeBean(ViewModel.textFieldBean)
            val selectedBrick = ViewModel.selectedBrick()
            when (selectedBrick) {
                is TextFieldBrick -> selectedBrick.binder.readBean(ViewModel.textFieldBean)
                is TextAreaBrick -> selectedBrick.binder.readBean(ViewModel.textFieldBean)
            }
        }
    }
}