package de.kotlincook.vaadin.bricksview.bricks

import com.vaadin.flow.component.textfield.TextArea
import de.kotlincook.vaadin.bricksview.BricksView
import de.kotlincook.vaadin.vaadinutil.Selectable
import de.kotlincook.vaadin.vaadinutil.ancestor2
import de.kotlincook.vaadin.vaadinutil.ancestor3

class TextAreaBrick : Brick() {

    init {
        className = "brick textarea-brick"
        val textArea = TextArea()
        textArea.className = "textarea"
        textArea.value = "text area text"
        add(textArea)
        add(Trash{
//            ancestor2<BricksView>()!!.delete(this)
            ancestor3(BricksView::class)!!.delete(this)
        })
        add(SelectArea())
    }

    override fun select() {
        classNames.remove("brick-nonSelected")
        classNames.add("brick-selected")
        children.forEach {
            if (it is Selectable) it.select()
        }
    }

    override fun unselect() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}