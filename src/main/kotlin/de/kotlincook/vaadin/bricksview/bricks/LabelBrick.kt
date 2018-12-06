package de.kotlincook.vaadin.bricksview.bricks

import com.vaadin.flow.component.html.Label
import de.kotlincook.vaadin.model.SafeModel

class LabelBrick : Brick() {
    override fun select() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unselect() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    init {
        className = "brick label-brick"
        val label = Label("")
        label.className = "label"
        label.text = "label text"
        add(label)
        add(Trash{
            SafeModel.bricksView.delete(this)
        })
    }

}