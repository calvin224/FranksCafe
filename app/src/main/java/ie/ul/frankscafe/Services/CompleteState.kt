package ie.ul.frankscafe.Services

import ie.ul.frankscafe.Model.db_entity.Food

class CompleteState() : State(CurrentOrder) {

    override fun onComplete(): String? {
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
}

