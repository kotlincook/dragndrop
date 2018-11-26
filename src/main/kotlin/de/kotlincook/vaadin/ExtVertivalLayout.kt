package de.kotlincook.vaadin

import com.vaadin.flow.component.Component
import com.vaadin.flow.component.orderedlayout.VerticalLayout

open class ExtVertivalLayout: VerticalLayout() {

    val components: MutableList<Component> = mutableListOf()

    override fun add(vararg components: Component) {
        super.add(*components)
        this.components.addAll(components)
    }

    fun insert(pos: Int, component: Component) {
        require(pos in 0 until components.size) {
            "Value of pos = $pos is not in '0 until ${components.size}'"
        }
        add(component)
//        components.add(component)
        for (i in components.lastIndex downTo pos+1) {
            swapComponents(i)
        }
    }

    private fun swapComponents(i: Int) {
        replace(components[i - 1], components[i])
        val temp = components[i - 1]
        components[i - 1] = components[i]
        components[i] = temp
    }

}