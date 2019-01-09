package de.kotlincook.vaadin.treeview

import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.component.treegrid.TreeGrid
import java.util.*

class TreeView : VerticalLayout() {
    init {
        val grid = TreeGrid(Node::class.java)
        grid.setHierarchyColumn("name")

        val dad = Node("dad", null)
        val son = Node("son", dad)
        val daughter = Node("daughter", dad)
        val all = Arrays.asList(dad, son, daughter)

        all.forEach { p -> grid.getTreeData().addItem(p.parent, p) }

        add(grid)
    }

}