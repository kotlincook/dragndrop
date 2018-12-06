package de.kotlincook.vaadin.bricksview.bricks

import com.vaadin.flow.component.textfield.TextField
import de.kotlincook.vaadin.bricksview.BricksView
import de.kotlincook.vaadin.vaadinutil.ancestor2
import de.kotlincook.vaadin.vaadinutil.ancestor3

class TextFieldBrick : Brick() {
    override fun select() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unselect() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    init {
        className = "brick textfield-brick"
        val textField = TextField()
        textField.className = "textfield"
        textField.value = "text field value"
        add(textField)
        add(Trash{
            ancestor3(BricksView::class)!!.delete(this)
        })
//        add(Trash{
//            SafeModel.bricksView.delete(this)
//        })
    }

}