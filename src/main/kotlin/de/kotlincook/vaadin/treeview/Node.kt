package de.kotlincook.vaadin.treeview

class Node(var name: String, var parent: Node?) {
    override fun toString(): String {
        return name
    }
}

