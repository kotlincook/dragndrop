package de.kotlincook.vaadin.vaadinutil

import com.google.gson.Gson
import com.vaadin.flow.component.Component
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import de.kotlincook.vaadin.bricksview.DropJoint
import org.apache.commons.lang3.SerializationUtils
import kotlin.streams.toList

abstract class DragNDropVerticalLayout : VerticalLayout() {

    protected val essentialComps: MutableList<Component> = mutableListOf()

    init {
        implantDropAreas()
        consistencyCheck()
    }

    fun append(vararg compsToAdd: Component) {
        validateNotToBeAnEssentialComp(compsToAdd)
        essentialComps.addAll(compsToAdd)
        implantDropAreas()
        consistencyCheck()
    }

    fun insert(beforeMe: Component, vararg compsToAdd: Component) {
        validateNotToBeAnEssentialComp(compsToAdd)
        val component = findEssentialCompAfter(beforeMe)
        if (component == null) {
            essentialComps.addAll(compsToAdd)
        }
        else {
            val index = essentialComps.indexOf(component)
            essentialComps.addAll(index, compsToAdd.asList())
        }
        implantDropAreas()
        consistencyCheck()
    }

    fun move(beforeMe: Component, compToMove: Component) {
        validateToBeEssentialComp(compToMove)
        essentialComps.remove(compToMove)
        remove(compToMove)
        insert(beforeMe, compToMove)
        consistencyCheck()
    }

    fun delete(compToDelete: Component) {
        validateToBeEssentialComp(compToDelete)
        essentialComps.remove(compToDelete)
        remove(compToDelete)
        implantDropAreas()
        consistencyCheck()
    }

    fun double(afterMe: Component, compToAdd: Component) {
        val component = findCompAfter(afterMe)
        insert(component!!, compToAdd)
    }

    protected fun implantDropAreas() {
        removeAll()
        super.add(createDropArea())
        for (comp in essentialComps) {
            super.add(comp)
            super.add(createDropArea())
        }
    }

    abstract fun createDropArea(): Component

    private fun validateNotToBeAnEssentialComp(comps: Array<out Component>) {
        comps.forEach {
            require(it !in essentialComps) {
                "$it cannot be added twice."
            }
        }
    }

    private fun validateToBeEssentialComp(comp: Component) {
        require(comp in essentialComps) {
            "$comp must be a member of the essential components"
        }
    }

    private fun findEssentialCompAfter(component: Component): Component? {
        var found = false
        for (child in children) {
            if (child == component) found = true
            if (found && child in essentialComps) return child
        }
        return null
    }

    private fun findCompAfter(component: Component): Component? {
        var found = false
        for (child in children) {
            if (found) return child
            if (child == component) found = true
        }
        return null
    }

    private fun consistencyCheck() {
        var expectDropArea = true
        var idx = 0
        for (comp in children) {
            require(
                if (expectDropArea) (comp is DropJoint)
                else  comp == essentialComps[idx++]
            ) {
                "Consistency check failed: " +
                "essentialComps = $essentialComps, children = ${children.toList()}"
            }
            expectDropArea = !expectDropArea
        }
    }
}