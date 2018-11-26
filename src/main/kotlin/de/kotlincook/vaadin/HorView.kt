package de.kotlincook.vaadin

import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.router.Route
import de.kotlincook.MainLayout


@Route(value = "hori", layout = MainLayout::class)
class HorView : HorizontalLayout() {
    companion object {
        const val VIEW_NAME = "MyView"
    }
    init {
        setSizeFull() // muss, damit Prozente funktionieren
        val treeView = TreeView()
//        val designerView = DesignerView()
        val personView = PersonView()
        val rudolfView = RudolfView()
        treeView.width = "20%"
//        designerView.width = "50%"
        rudolfView.width = "50%"
        personView.width = "30%"
        add(treeView)
//        add(designerView)
        add(rudolfView)
        add(personView)
//        val label = Label("Hallo Weltenbummler")
//        val button = Button("Klick mich mal")
//        button.addClickListener { _ -> add(Label("Knopf wurde geklickt")) }
//        add(label, button)
    }
}
