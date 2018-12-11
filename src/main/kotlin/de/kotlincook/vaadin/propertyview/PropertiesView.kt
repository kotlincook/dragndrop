package de.kotlincook.vaadin.propertyview

import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.component.textfield.TextField
import com.vaadin.flow.data.binder.Binder
import de.kotlincook.vaadin.bricksview.bricks.Brick
import de.kotlincook.vaadin.bricksview.bricks.TextFieldBrick
import de.kotlincook.vaadin.viewmodel.ViewModel
import de.kotlincook.vaadin.viewmodel.TextFieldBean

class PropertiesView : VerticalLayout() {

    val valueField = TextField("Value")
    val binder = Binder(TextFieldBean::class.java).apply {
        forMemberField(valueField).bind("value")
        bean = ViewModel.textFieldBean
    }

    init {
        isSpacing = false
        add(TextField("Caption"))
        add(valueField)

        binder.addValueChangeListener {
            binder.writeBean(ViewModel.textFieldBean)
            val selectedBrick = ViewModel.selectedBrick()
            if (selectedBrick is TextFieldBrick) {
                selectedBrick.binder.readBean(ViewModel.textFieldBean)
            }
        }
    }
}