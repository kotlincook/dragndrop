package de.kotlincook.vaadin

import com.vaadin.flow.component.Component


class KarinView : DragNDropVerticalLayout() {
    init {
        isSpacing = false
//        append(Label("Weltenmann"))
//        append(Label("Ich"))
//        append(Line())
//        append(Label("bin"))
//        append(Line())
//        append(Label("beim"))
//        append(Label("Pinkeln"))
    }


    override fun createDropArea(): Component {
        return DropLine { e ->
            val draggedComp = pullDraggedComponent() ?: return@DropLine
            when(draggedComp) {
                is Line -> move(this, draggedComp)
                is TextFieldSample -> insert(this, TextFieldLine())
                is LabelSample -> insert(this, LabelLine())
                else -> insert(this, LabelLine())
            }
        }
    }

}
