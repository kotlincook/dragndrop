package de.kotlincook.vaadin.propertyview

import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.component.textfield.TextField
import de.kotlincook.vaadin.model.SafeModel

class PropertiesView : VerticalLayout() {
    init {
        SafeModel.propertiesView = this
        isSpacing = false
        add(TextField("Caption"))
        add(TextField("Value"))
    }
}