package de.kotlincook.vaadin.vaadinutil

import com.vaadin.flow.component.Component
import com.vaadin.flow.component.ComponentEvent
import com.vaadin.flow.component.DomEvent
import com.vaadin.flow.component.UI
import com.vaadin.flow.component.page.Page
import com.vaadin.flow.dom.Element

const val ATTR_KEY_DRAGGED_COMPONENT = "DRAGGED_COMPONENT"

fun pullDraggedComponent(): Component? {
    val session = UI.getCurrent().session
    session.lock()
    try {
        val draggedComp = session.getAttribute(ATTR_KEY_DRAGGED_COMPONENT)
        session.setAttribute(ATTR_KEY_DRAGGED_COMPONENT, null)
        return draggedComp as Component?
    } finally {
        session.unlock()
    }
}


fun pushDraggedComponent(component: Component) {
    val session = UI.getCurrent().session
    session.lock()
    try {
        session.setAttribute(ATTR_KEY_DRAGGED_COMPONENT, component)
    } finally {
        session.unlock()
    }
}


@DomEvent("dragstart")
class DragstartEvent<T : Component>(source : T, fromClient : Boolean) : ComponentEvent<T>(source, fromClient)


@DomEvent("drop")
class DropEvent<T : Component>(source: T, fromClient: Boolean) : ComponentEvent<T>(source, fromClient)


fun Page.addDropSupport(element: Element) {
    executeJavaScript("""
    |// both the dragover handler and "e.preventDefault()" are essential
    |function handleDrop(e) {
    |  console.log("DROP")
    |  this.classList.remove('hover-active');
    |  e.preventDefault();
    |}
    |function handleDragEnter(e) {
    |   // this / e.target is the current hover target.
    |   this.classList.add('hover-active');
    |}
    |function handleDragLeave(e) {
    |   // this / e.target is the current hover target.
    |   this.classList.remove('hover-active');
    |}
    |function handleDragover(e) {
    |   // this.style.backgroundColor = 'yellow';
    |   e.preventDefault();
    |}
    |// $0 kann unter Umständen wirklich null sein
    |if ($0 != null) {
    |   $0.addEventListener('dragover', handleDragover, false);
    |   $0.addEventListener('dragenter', handleDragEnter, false);
    |   $0.addEventListener('dragleave', handleDragLeave, false);
    |   $0.addEventListener('drop', handleDrop, false);
    |}
    """.trimMargin(), element)
}

fun Page.addDragSupport(element: Element) {
    element.setAttribute("draggable", "true")
    element.setAttribute("style", "cursor:grabbing")
    executeJavaScript("""
    |function handleDragStart(e) {
    |   console.log("START")
    |   this.style.opacity = '0.4';
    |   // workaround for Firefox, IE only supports 'text':
    |   e.dataTransfer.setData('text', 'foo');
    |}
    |function handleDragEnd(e) {
    |   this.style.opacity = '';
    |}
    |
    |// $0 kann unter Umständen wirklich null sein
    |if ($0 != null) {
    |   $0.addEventListener('dragstart', handleDragStart, false);
    |   $0.addEventListener('dragend', handleDragEnd, false);
    |}
    """.trimMargin(), element)

}