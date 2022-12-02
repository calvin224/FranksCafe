package ie.ul.frankscafe.Services

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import ie.ul.frankscafe.Model.db_entity.Food
import ie.ul.frankscafe.Model.entity.FoodEntity

class IncompleteState() : State(CurrentOrder) {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onComplete(application: Application): String? {
        currentOrder.processOrder(application)
        currentOrder.changeState(CompleteState())
        currentOrder.clear()
        return "Order Processed"
    }

    override fun onAdd(food: FoodEntity): String? {
        currentOrder.addItem(food)
        return "Food Added"
    }

    override fun onUndo(foodlist: ArrayList<FoodEntity>?): String? {
        if (foodlist != null) {
            currentOrder.Undo(foodlist)
        }
        return "Change Undone"
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onRemove(food: FoodEntity): String? {
        currentOrder.removeItem(food)
        return "Food Removed"
    }
    override fun getOrder(): ArrayList<FoodEntity> {
        return currentOrder.getOrders()
    }

    override fun clear(){
        currentOrder.clear()
    }

}