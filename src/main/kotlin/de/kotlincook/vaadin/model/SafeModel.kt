package de.kotlincook.vaadin.model

import de.kotlincook.vaadin.bricksview.BricksView
import de.kotlincook.vaadin.propertyview.PropertiesView

object SafeModel {
    lateinit var bricksView: BricksView
    lateinit var propertiesView: PropertiesView

    val bindingBean = TextfieldBean("Voll erkältet")
}