package de.kotlincook.vaadin.viewmodel

import de.kotlincook.vaadin.bricksview.bricks.Brick
import de.kotlincook.vaadin.mainview.MainView

object ViewModel {

    lateinit var mainView: MainView
    val bricksView get() = mainView.bricksView
    val propertiesView get() = mainView.leftView.propertiesView

    fun selectedBrick() = bricksView.essentialComps.find { it is Brick && it.selected }

    // erst mal hier:
    val textFieldBean = TextFieldBean()
}