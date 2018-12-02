package de.kotlincook.vaadin.Backup

import com.vaadin.flow.component.Component
import com.vaadin.flow.component.orderedlayout.VerticalLayout

open class ExtVertivalLayout: VerticalLayout() {

    protected val components: MutableList<Component> = mutableListOf()

    private fun consistencyCheck() {
        println("CONSISTENCYCONSISTENCYCONSISTENCYCONSISTENCYCONSISTENCYCONSISTENCY")

        require(componentCount == components.size)
        val childrenArray = children.toArray()
        components.forEachIndexed { i, comp ->
            require(comp == childrenArray[i])
        }
    }

    override fun add(vararg compsToAdd: Component) {
        println("ADDEDADDEDADDEDADDEDADDEDADDEDADDEDADDEDADDEDADDED")
        super.add(*compsToAdd)
        components.removeAll(compsToAdd)
        components.addAll(compsToAdd)
        consistencyCheck()
    }

    override fun remove(vararg compsToRemove: Component) {
        println("REMOVEREMOVEREMOVEREMOVEREMOVEREMOVEREMOVEREMOVER")
        super.remove(*compsToRemove)
        components.removeAll(compsToRemove)
        consistencyCheck()
    }

    fun remove(pos: Int) {
        remove(components[pos])
    }

    fun move(compToMove: Component, beforeMe: Component) {
        components.remove(compToMove)
        insert(components.indexOf(beforeMe), compToMove)
    }

    fun move(pos: Int, beforeMe: Component) {
        move(components[pos], beforeMe)
    }

    fun insert(beforeMe: Component, vararg compsToInsert: Component) {
        insert(indexOf(beforeMe), *compsToInsert)
    }

    fun insert(pos: Int, vararg compsToInsert: Component) {

        fun swapComponents(i: Int) {
            replace(components[i - 1], components[i])
            val temp = components[i - 1]
            components[i - 1] = components[i]
            components[i] = temp
        }

        require(pos in 0..components.size) {
            "Value of pos = $pos is not in '0..${components.size}'"
        }
        compsToInsert.forEach { require(it !in components) }

        val prevComponentsSize = components.size
        add(*compsToInsert)
        for (i in prevComponentsSize downTo pos + 1) {
            for (j in i until i + compsToInsert.size) {
                swapComponents(j)
            }
        }
        consistencyCheck()
    }// insert

}