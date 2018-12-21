package de.kotlincook.vaadin.leftview

import com.vaadin.flow.component.html.Label
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import de.kotlincook.vaadin.propertyview.TextFieldPropertiesView
import de.kotlincook.vaadin.treeview.TreeView

class LeftView : VerticalLayout() {

    var propertiesView = TextFieldPropertiesView()
    val treeView = TreeView()

    init {
        isSpacing = false
        add(Label("Eigenschaften"))
        add(propertiesView)
        add(treeView)
    }
}