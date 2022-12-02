package ie.ul.frankscafe.Services

import android.app.Application
import ie.ul.frankscafe.Model.db_entity.Food

class CompleteState() : State(CurrentOrder) {

    override fun onComplete(application: Application): String? {
        return "Order Completed, Action Locked"
    }

    override fun onAdd(food: Food): String? {
        return "Order Completed, Action Locked"
    }

    override fun onUndo(foodlist: ArrayList<Food>?): String? {
        return "Order Completed, Action Locked"
    }

    override fun onRemove(food: Food): String? {
        return "Order Completed, Action Locked"
    }

    override fun getOrder(): ArrayList<Food>? {
        return currentOrder.getOrders()
    }
    override fun clear(){
        currentOrder.clear()
    }
}

