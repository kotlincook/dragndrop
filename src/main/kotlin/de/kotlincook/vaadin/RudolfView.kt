package de.kotlincook.vaadin

import com.vaadin.flow.component.html.Label


class RudolfView : ExtVertivalLayout() {
    init {
        isSpacing = false
        val weltenmann = Label("Weltenmann")
        add(weltenmann)
        insert(0, Label("Kuchenaufgabe"))
        add(Line())
        add(Label("Ich"))
//        add(Line())
        add(createDropLine())
//        add(Line())
        add(Label("bin"))
//        add(DropLine { println("Hallo")})
//        add(Label("beim"))
//        add(Label("Pinkeln"))
//        val vonMarkus = Label("Von Markus")
//        insert(0, Label("Kuchenaufgabe"), vonMarkus)
//        remove(vonMarkus)
    }

    fun createDropLine(): DropLine {
        return DropLine { e ->
            val draggedComp = pullDraggedComponent()
            println("#############" + draggedComp)
            if (draggedComp == null) return@DropLine
            if (draggedComp is Line) {
                move(draggedComp, this)
//                remove(draggedComp)
//                remove(indexOf(draggedComp) + 1)
//                insert(this, createDropLine(), draggedComp)
            }
            else {
                insert(this, createDropLine(), Label("Holger"))
            }
        }
    }


}
