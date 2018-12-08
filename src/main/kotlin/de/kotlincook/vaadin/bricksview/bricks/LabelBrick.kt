package de.kotlincook.vaadin.bricksview.bricks

import com.vaadin.flow.component.ClickEvent
import com.vaadin.flow.component.html.Label
import de.kotlincook.vaadin.bricksview.BricksView
import de.kotlincook.vaadin.bricksview.Copy
import de.kotlincook.vaadin.bricksview.SelectArea
import de.kotlincook.vaadin.bricksview.Trash
import de.kotlincook.vaadin.vaadinutil.ancestor

class LabelBrick : Brick() {

    init {
        className = "brick label-brick"
        val label = Label("")
        label.className = "label"
        label.text = "label text"
        add(label)

        add(Trash {
            ancestor(BricksView::class).delete(this)
        })
        add(Copy {
            ancestor(BricksView::class).double(this, this.clone())
        })
        addListener(ClickEvent::class.java) {
            select()
        }
//        add(SelectArea {
//            select()
//        })
    }

    override fun clone(): LabelBrick {
        return LabelBrick()
    }

}