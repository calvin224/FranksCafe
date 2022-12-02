package ie.ul.frankscafe.Services

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import ie.ul.frankscafe.Model.db_entity.Food

abstract class IncompleteState(application: Application) : State(CurrentOrder) {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onComplete(application: Application): String? {
        currentOrder.changeState(CompleteState())
        currentOrder.processOrder(application)
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

    override fun clear(){
        currentOrder.clear()
    }

}