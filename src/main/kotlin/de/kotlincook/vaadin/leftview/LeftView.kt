package de.kotlincook.vaadin.leftview

import com.vaadin.flow.component.html.Label
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import de.kotlincook.vaadin.propertyview.LabelPropertiesView
import de.kotlincook.vaadin.propertyview.PropertiesView
import de.kotlincook.vaadin.propertyview.TextFieldPropertiesView
import de.kotlincook.vaadin.treeview.TreeView

class LeftView : VerticalLayout() {

    var propertiesView: PropertiesView = TextFieldPropertiesView()
    val textFieldPropertiesView = TextFieldPropertiesView()
    val labelPropertiesView = LabelPropertiesView()
    val treeView = TreeView()

    fun showTextFieldPropertiesView() {
        removeAll()
        add(Label("Eigenschaften"))
        add(textFieldPropertiesView)
        propertiesView = textFieldPropertiesView
        add(treeView)
    }


    fun showLabelPropertiesView() {
        removeAll()
        add(Label("Eigenschaften"))
        add(labelPropertiesView)
        propertiesView = labelPropertiesView
        add(treeView)
    }

    init {
        isSpacing = false
        showLabelPropertiesView()
    }
}