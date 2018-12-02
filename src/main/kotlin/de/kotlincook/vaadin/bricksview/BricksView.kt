package de.kotlincook.vaadin.bricksview

import com.vaadin.flow.component.Component
import de.kotlincook.vaadin.vaadinutil.DragNDropVerticalLayout
import de.kotlincook.vaadin.bricksview.bricks.LabelBrick
import de.kotlincook.vaadin.bricksview.bricks.Brick
import de.kotlincook.vaadin.bricksview.bricks.TextAreaBrick
import de.kotlincook.vaadin.bricksview.bricks.TextFieldBrick
import de.kotlincook.vaadin.vaadinutil.pullDraggedComponent
import de.kotlincook.vaadin.sampleview.samples.LabelSample
import de.kotlincook.vaadin.sampleview.samples.TextAreaSample
import de.kotlincook.vaadin.sampleview.samples.TextFieldSample


class BricksView : DragNDropVerticalLayout() {
    init {
        isSpacing = false
    }

    override fun createDropArea(): Component {
        return DropJoint { e ->
            val draggedComp = pullDraggedComponent() ?: return@DropJoint
            when (draggedComp) {
                is Brick -> move(this, draggedComp)
                is TextFieldSample -> insert(this, TextFieldBrick())
                is TextAreaSample -> insert(this, TextAreaBrick())
                is LabelSample -> insert(this, LabelBrick())
                else -> insert(this, LabelBrick())
            }
        }
    }

}
