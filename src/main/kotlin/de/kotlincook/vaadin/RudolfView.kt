package de.kotlincook.vaadin

import com.vaadin.flow.component.html.Label


class RudolfView : ExtVertivalLayout() {
    init {
        isSpacing = false
        add(Label("Weltenmann"))
        add(Label("Ich"))
        add(DropLine() { e ->
            println("Hier wurde was eingefügt" + this::class)
            println("Event war: $e")
            // insert(0, Label("Neuermann"))
        })
        add(Label("bin"))
        add(DropLine() { println("Hallo")})
        add(Label("beim"))
        add(Label("Pinkeln"))
        insert(5, Label("Kuchenaufgabe"))
    }
}
