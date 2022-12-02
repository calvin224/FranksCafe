package ie.ul.frankscafe.Services

import android.app.Application
import ie.ul.frankscafe.Model.entity.FoodEntity

abstract class State {
    var currentOrder = CurrentOrder

    constructor(currentOrder: CurrentOrder) {
        this.currentOrder = currentOrder
    }

    abstract fun onComplete(application: Application): String?
    abstract fun onAdd(food: FoodEntity): String?
    abstract fun onUndo(foodlist: ArrayList<FoodEntity>?): String?
    abstract fun onRemove(food: FoodEntity): String?
    abstract fun getOrder(): ArrayList<FoodEntity>
    abstract fun clear()
}