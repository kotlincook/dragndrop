package de.kotlincook.vaadin.mainview

import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.router.Route
import de.kotlincook.MainLayout
import de.kotlincook.vaadin.bricksview.BricksView
import de.kotlincook.vaadin.leftview.LeftView
import de.kotlincook.vaadin.sampleview.SampleView
import de.kotlincook.vaadin.viewmodel.ViewModel


@Route(value = "main", layout = MainLayout::class)
class MainView : HorizontalLayout() {

    val leftView = LeftView().apply {
        className = "left-view"
    }
    val bricksView = BricksView().apply {
        className = "bricks-view"
    }
    val sampleView = SampleView().apply {
        className = "sample-view"
    }

    init {
        ViewModel.mainView = this
        setSizeFull() // muss, damit Prozente funktionieren
        add(leftView)
        add(bricksView)
        add(sampleView)
    }
}
