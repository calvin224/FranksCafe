package ie.ul.frankscafe.Services

import ie.ul.frankscafe.Model.db_entity.Food

class Originator(var state: Food) {

    fun createMemento(): Memento {
        return Memento(state)
    }

    fun restore(memento: Memento) {
        state = memento.state
    }
}