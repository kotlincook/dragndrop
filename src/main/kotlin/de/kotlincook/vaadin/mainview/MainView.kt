package de.kotlincook.vaadin.mainview

import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.router.Route
import de.kotlincook.MainLayout
import de.kotlincook.vaadin.bricksview.BricksView
import de.kotlincook.vaadin.leftview.LeftView
import de.kotlincook.vaadin.sampleview.SampleView
import de.kotlincook.vaadin.treeview.TreeView


@Route(value = "main", layout = MainLayout::class)
class MainView : HorizontalLayout() {
    init {
        setSizeFull() // muss, damit Prozente funktionieren
        val treeView = TreeView()
        val leftView = LeftView()
        val bricksView = BricksView()
        val sampleView = SampleView()
        leftView.width = "20%"
//        treeView.width = "20%"
        bricksView.width = "50%"
        sampleView.width = "30%"
        add(leftView)
        add(bricksView)
        add(sampleView)
    }
}
