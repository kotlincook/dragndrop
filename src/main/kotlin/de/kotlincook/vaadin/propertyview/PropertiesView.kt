package de.kotlincook.vaadin.propertyview

import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.data.binder.Binder

abstract class PropertiesView: VerticalLayout() {

    abstract val propertiesBinder: Binder<Any>
}