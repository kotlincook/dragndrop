package de.kotlincook.vaadin.bricksview.bricks

import com.vaadin.flow.component.textfield.TextArea
import de.kotlincook.vaadin.model.SafeModel
import de.kotlincook.vaadin.vaadinutil.Selectable

class TextAreaBrick : Brick() {

    init {
        className = "brick textarea-brick"
        val textArea = TextArea()
        textArea.className = "textarea"
        textArea.value = "text area text"
        add(textArea)
        add(Trash{
            SafeModel.bricksView.delete(this)
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