package ie.ul.frankscafe.Services

import ie.ul.frankscafe.Model.db_entity.Food

abstract class State {
    var currentOrder = CurrentOrder

    constructor(currentOrder: CurrentOrder) {
        this.currentOrder = currentOrder
    }

    abstract fun onComplete(): String?
    abstract fun onAdd(food: Food): String?
    abstract fun onUndo(foodlist: ArrayList<Food>?): String?
    abstract fun onRemove(food: Food): String?
    abstract fun getOrder(): ArrayList<Food>?
}