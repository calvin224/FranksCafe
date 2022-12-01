package ie.ul.frankscafe.Services

import ie.ul.frankscafe.Model.db_entity.Food

abstract class IncompleteState() : State(CurrentOrder) {

    override fun onComplete(): String? {
        currentOrder.changeState(CompleteState())
        return "Order Processed"
    }

    override fun onAdd(food: Food): String? {
        currentOrder.addItem(food)
        return "Food Added"
    }

    override fun onUndo(foodlist: ArrayList<Food>?): String? {
        if (foodlist != null) {
            currentOrder.Undo(foodlist)
        }
        return "Change Undone"
    }

    override fun onRemove(food: Food): String? {
        currentOrder.removeItem(food)
        return "Food Removed"
    }
    override fun getOrder(): ArrayList<Food>? {
        return currentOrder.getOrders()
    }

}