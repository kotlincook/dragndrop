package de.kotlincook.vaadin

import com.vaadin.flow.component.html.Label
import com.vaadin.flow.component.orderedlayout.VerticalLayout

class PersonView : VerticalLayout() {
    init {
//        val grid = Grid<Person>()
//        grid.addColumn(Person::vorname).setHeader("Vorname")
//        grid.addColumn(Person::nachname).setHeader("Nachname")
//        grid.setItems(PersonService.findAll())
        add(Label("Liste der einzufügden Elemente"))
        add(TextFieldSample())
        add(TextAreaSample())
        add(LabelSample())
    }
}
