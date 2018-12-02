package de.kotlincook.vaadin

import com.vaadin.flow.component.Component


class KarinView : DragNDropVerticalLayout() {
    init {
        isSpacing = false
    }


    override fun createDropArea(): Component {
        return DropLine { e ->
            val draggedComp = pullDraggedComponent() ?: return@DropLine
            when(draggedComp) {
                is Line -> move(this, draggedComp)
                is TextFieldSample -> insert(this, TextFieldLine())
                is TextAreaSample -> insert(this, TextAreaLine())
                is LabelSample -> insert(this, LabelLine())
                else -> insert(this, LabelLine())
            }
        }
    }

}
