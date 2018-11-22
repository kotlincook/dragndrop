package de.kotlincook.vaadin

import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.html.Label
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.Route
import de.kotlincook.MainLayout


@Route(value = "hello", layout = MainLayout::class)
class MyView : VerticalLayout() {
    companion object {
        const val VIEW_NAME = "MyView"
    }
    init {
        val label = Label("Hallo Weltenbummler")
        val button = Button("Klick mich mal")
        button.addClickListener { _ -> add(Label("Knopf wurde geklickt")) }
        add(label, button)
        add(PersonView())
    }
}
