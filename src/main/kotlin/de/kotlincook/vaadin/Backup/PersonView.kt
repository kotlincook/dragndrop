package de.kotlincook.vaadin.Backup

import com.vaadin.flow.component.grid.Grid
import com.vaadin.flow.component.orderedlayout.VerticalLayout

// Nur als Kopie
class PersonView : VerticalLayout() {
    init {
        val grid = Grid<Person>()
        grid.addColumn(Person::vorname).setHeader("Vorname")
        grid.addColumn(Person::nachname).setHeader("Nachname")
        grid.setItems(PersonService.findAll())
    }
}
