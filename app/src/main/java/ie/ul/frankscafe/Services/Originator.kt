package ie.ul.frankscafe.Services

import ie.ul.frankscafe.Model.entity.FoodEntity

class Originator(var state: FoodEntity) {

    fun createMemento(): Memento {
        return Memento(state)
    }

    fun restore(memento: Memento) {
        state = memento.state
    }
}