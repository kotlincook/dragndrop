package de.kotlincook.vaadin

import com.vaadin.flow.component.ComponentEvent
import com.vaadin.flow.component.DomEvent
import com.vaadin.flow.component.UI
import com.vaadin.flow.component.html.Label
import com.vaadin.flow.component.orderedlayout.VerticalLayout


@DomEvent("drop")
class DropEvent(source: MyLabel, fromClient: Boolean) : ComponentEvent<MyLabel>(source, fromClient)

class MyLabel(text: String, listener: (DropEvent) -> Unit) : Label(text) {
    init {
        UI.getCurrent().page.addDropSupport(element)
        addListener(DropEvent::class.java, listener)
    }
}


class DesignerView : VerticalLayout() {
    init {
        val label = MyLabel("Hallo") { e ->
            println("Ich droppe gerade " + e.source)
        }
        add(label)
        add(Label("Weltenmann"))
        add(Label("Ich"))
        add(Label("bin"))
        add(Label("beim"))
        add(Label("Zahnarzt"))
//        UI.getCurrent().page.addDropSupport(element)
    }
}
