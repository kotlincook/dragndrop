package de.kotlincook.vaadin.leftview

import com.vaadin.flow.component.html.Label
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import de.kotlincook.vaadin.propertyview.PropertiesView
import de.kotlincook.vaadin.treeview.TreeView

class LeftView : VerticalLayout() {
  init {
      isSpacing = false
      add(Label("Eigenschaften"))
      add(PropertiesView())
      add(TreeView())
  }
}