package de.kotlincook.vaadin.viewmodel

import de.kotlincook.vaadin.bricksview.bricks.Brick
import de.kotlincook.vaadin.mainview.MainView

object ViewModel {

    lateinit var mainView: MainView
    val bricksView get() = mainView.bricksView
    var propertiesView
        get() = mainView.leftView.propertiesView
        set(value) { mainView.leftView.propertiesView = value }

    fun selectedBrick() = bricksView.essentialComps.find { it is Brick && it.selected }

    // erst mal hier:
    val textFieldBean = TextFieldBean()
}