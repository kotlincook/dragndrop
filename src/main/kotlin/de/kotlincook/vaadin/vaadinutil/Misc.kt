package de.kotlincook.vaadin.vaadinutil

import com.vaadin.flow.component.Component
import kotlin.reflect.KClass

fun <T : Any>Component.ancestorOrNull(clazz: KClass<T>): T? {
    var candidate = this
    repeat(100) {
        if (candidate::class == clazz) return candidate as T
        if (!candidate.parent.isPresent) return null
        candidate = candidate.parent.get()
    }
    throw IllegalStateException("Ancestor search exceeds 100 iterations")
}

fun <T : Any>Component.ancestor(clazz: KClass<T>): T {
    return ancestorOrNull(clazz)?:
    throw IllegalStateException("There is no ancestor with class $clazz.")
}


inline fun <reified T>Component.ancestor2(): T? {
    if (this is T) return this // Dies ist notwendig, ganz extra zu behandeln!
    var candidate = this.parent.get()
    for (i in 0..100) {
        if (candidate is T) return candidate
        if (!candidate.parent.isPresent) return null
        candidate = candidate.parent.get()
    }
    throw IllegalStateException("Ancestor search exceeds 100 iterations")
}