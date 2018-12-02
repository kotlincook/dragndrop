package de.kotlincook.vaadin.mainview

import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.router.Route
import de.kotlincook.MainLayout
import de.kotlincook.vaadin.bricksview.BricksView
import de.kotlincook.vaadin.sampleview.SampleView
import de.kotlincook.vaadin.treeview.TreeView


@Route(value = "main", layout = MainLayout::class)
class MainView : HorizontalLayout() {
    companion object {
        const val VIEW_NAME = "MyView"
    }
    init {
        setSizeFull() // muss, damit Prozente funktionieren
        val treeView = TreeView()
        val personView = SampleView()
        val mainView = BricksView()
        treeView.width = "20%"
        mainView.width = "50%"
        personView.width = "30%"
        add(treeView)
        add(mainView)
        add(personView)
    }
}
