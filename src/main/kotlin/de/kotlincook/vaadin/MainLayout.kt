package de.kotlincook

import com.vaadin.flow.component.dependency.StyleSheet
import com.vaadin.flow.component.orderedlayout.FlexLayout
import com.vaadin.flow.router.RouterLayout
import com.vaadin.flow.theme.Theme
import com.vaadin.flow.theme.lumo.Lumo

/**
 * The layout of the pages e.g. About and Inventory.
 */
@StyleSheet("css/shared-styles.css")
@Theme(value = Lumo::class, variant = Lumo.LIGHT)
class MainLayout : FlexLayout(), RouterLayout {

    init {
        setSizeFull()
    }
}
