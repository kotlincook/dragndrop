package de.kotlincook.vaadin.sampleview

import com.vaadin.flow.component.html.Label
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import de.kotlincook.vaadin.sampleview.samples.LabelSample
import de.kotlincook.vaadin.sampleview.samples.TextAreaSample
import de.kotlincook.vaadin.sampleview.samples.TextFieldSample

class SampleView : VerticalLayout() {
    init {
        add(Label("Liste einfügbarer Elemente"))
        add(TextFieldSample())
        add(TextAreaSample())
        add(LabelSample())
    }
}
