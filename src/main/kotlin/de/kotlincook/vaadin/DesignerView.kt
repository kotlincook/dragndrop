package de.kotlincook.vaadin

import com.vaadin.flow.component.UI
import com.vaadin.flow.component.html.Label
import com.vaadin.flow.component.orderedlayout.VerticalLayout


class MyLabel(text: String, listener: (DropEvent<*>) -> Unit) : Label(text) {
    init {
        UI.getCurrent().page.addDropSupport(element)
        addListener(DropEvent::class.java, listener)
    }
}


class DesignerView : VerticalLayout() {
    init {
        val label = MyLabel("Hallo") { e ->
            println("Ich droppe gerade " + e.source)
            println(indexOf(e.source))
            val neues = Label("Neues Dingen")
            add(neues)
            replace(e.source, neues)
        }
        isSpacing = false
        add(label)
        add(Label("Weltenmann"))
        add(Label("Ich"))
//        add(DropLine())
        add(Label("bin"))
//        add(DropLine())
        add(Label("beim"))
//        add(DropLine())
        val zahnarzt = Label("Zahnarzt")
        add(zahnarzt)

//        add(DropLine())
        add(Label("bin"))
        val urologe = Label("Urologe")
        add(urologe)
        replace(zahnarzt, urologe)
         println(indexOf(urologe))
//        remove(zahnarzt)
//        UI.getCurrent().page.addDropSupport(element)
    }
}
