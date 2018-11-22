package de.kotlincook.vaadin

import com.vaadin.flow.component.page.Page
import com.vaadin.flow.dom.Element

fun Page.addDropSupport(element: Element) {
    executeJavaScript("""
    |// both the dragover handler and "e.preventDefault()" are essential
    |function handleDrop(e) {
    |  e.preventDefault();
    |}
    |function handleDragover(e) {
    |   e.preventDefault();
    |}
    |$0.addEventListener('dragover', handleDragover, false);
    |$0.addEventListener('drop', handleDrop, false);
    """.trimMargin(), element)
}


fun Page.addDragSupport(element: Element) {
    element.setAttribute("draggable", "true")
    element.setAttribute("style", "cursor:move")
    executeJavaScript("""
    |function handleDragStart(e) {
    |   this.style.opacity = '0.4';
    |   // workaround for Firefox, IE only supports 'text':
    |   e.dataTransfer.setData('text', 'foo');
    |}
    |function handleDragEnd(e) {
    |   this.style.opacity = '';
    |}
    |$0.addEventListener('dragstart', handleDragStart, false);
    |$0.addEventListener('dragend', handleDragEnd, false);
    """.trimMargin(), element)
}