package ie.ul.frankscafe.Services

import android.app.Application
import ie.ul.frankscafe.Model.db_entity.Food
import ie.ul.frankscafe.Model.entity.FoodEntity

class CompleteState() : State(CurrentOrder) {

    override fun onComplete(application: Application): String? {
        return "Order Completed, Action Locked"
    }

    override fun onAdd(food: FoodEntity): String? {
        return "Order Completed, Action Locked"
    }

    override fun onUndo(foodlist: ArrayList<FoodEntity>?): String? {
        return "Order Completed, Action Locked"
    }

    override fun onRemove(food: FoodEntity): String? {
        return "Order Completed, Action Locked"
    }

    override fun getOrder(): ArrayList<FoodEntity> {
        return currentOrder.getOrders()
    }
    override fun clear(){
        currentOrder.clear()
    }
}

