package de.kotlincook.vaadin.mainview

import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.router.Route
import de.kotlincook.MainLayout
import de.kotlincook.vaadin.bricksview.BricksView
import de.kotlincook.vaadin.sampleview.SampleView
import de.kotlincook.vaadin.treeview.TreeView


@Route(value = "main", layout = MainLayout::class)
class MainView : HorizontalLayout() {
    init {
        setSizeFull() // muss, damit Prozente funktionieren
        val treeView = TreeView()
        val sampleView = SampleView()
        val bricksView = BricksView()
        treeView.width = "20%"
        bricksView.width = "50%"
        sampleView.width = "30%"
        add(treeView)
        add(bricksView)
        add(sampleView)
    }
}
