package de.kotlincook.vaadin.propertyview

import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.component.textfield.TextField
import com.vaadin.flow.data.binder.Binder
import de.kotlincook.vaadin.bricksview.bricks.Brick
import de.kotlincook.vaadin.bricksview.bricks.TextFieldBrick
import de.kotlincook.vaadin.model.SafeModel
import de.kotlincook.vaadin.model.TextfieldBean

class PropertiesView : VerticalLayout() {

    val valueField = TextField("Value")
    val binder = Binder(TextfieldBean::class.java).apply {
        forMemberField(valueField).bind("value")
        bean = SafeModel.bindingBean
    }

    init {
        SafeModel.propertiesView = this
        isSpacing = false
        add(TextField("Caption"))
        add(valueField)

        binder.addValueChangeListener {
            println("Value changed")
            binder.writeBean(SafeModel.bindingBean)
            val selectedBrick = SafeModel.bricksView.essentialComps.find { it is Brick && it.selected }
            if (selectedBrick is TextFieldBrick) selectedBrick.binder.readBean(SafeModel.bindingBean)
        }
    }
}