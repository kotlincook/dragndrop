package de.kotlincook.vaadin

import com.vaadin.flow.component.html.Label
import com.vaadin.flow.component.orderedlayout.VerticalLayout


class DesignerView : VerticalLayout() {

    init {
        add(Label("Hallo"))
        add(Label("Weltenmann"))
        add(Label("Ich"))
        add(Label("bin"))
        add(Label("beim"))
        add(Label("Zahnarzt"))
        add(Piece("frontend/icons/rookWhite.png", "white_rook_A"))
    }
}
