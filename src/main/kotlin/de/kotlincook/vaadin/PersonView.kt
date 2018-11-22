package de.kotlincook.vaadin

import com.vaadin.flow.component.grid.Grid
import com.vaadin.flow.component.html.Label
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.Route
import com.vaadin.flow.theme.Theme
import com.vaadin.flow.theme.lumo.Lumo


@Route("persons")
@Theme(Lumo::class)
class PersonView : VerticalLayout() {
    init {
        val grid = Grid<Person>()
        grid.addColumn(Person::vorname).setHeader("Vorname")
        grid.addColumn(Person::nachname).setHeader("Nachname")
        grid.setItems(PersonService.findAll())
        add(Label("Liste der Personen"), grid)
        add(Square())
        add(Piece("frontend/icons/rookWhite.png", "white_rook_A"))
    }
}
