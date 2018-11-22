package de.kotlincook.vaadin

data class Person(val vorname: String, val nachname: String)

object PersonService {
    var persons = listOf(Person("Jörg", "Vollmer"), Person("Dieter", "Kramps"))

    fun findAll(): List<Person> {
        return persons
    }
}