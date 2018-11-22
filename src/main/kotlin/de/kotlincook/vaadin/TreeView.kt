package de.kotlincook.vaadin

import com.vaadin.flow.component.html.Label
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.component.treegrid.TreeGrid
import java.util.Arrays



class TreeView : VerticalLayout() {
    init {
        add(Label("Eier"))
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