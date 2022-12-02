package ie.ul.frankscafe.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import ie.ul.frankscafe.Model.db_entity.Food
import ie.ul.frankscafe.Model.entity.FoodEntity
import ie.ul.frankscafe.Services.CurrentOrder

class OrderViewModel(application: Application): AndroidViewModel(application)
{
    val app = application
    fun getAllFoodsByMealDeal(mealDeal: String): List<FoodEntity>{
       return FoodViewModel(app).getAllFoodsByMealDeal(mealDeal)
    }
    fun getFoodByName(foodName: String): FoodEntity{
        return FoodViewModel(app).getFoodByName(foodName)
    }
    fun getAll(): List<FoodEntity>{
        return FoodViewModel(app).getAll
    }

    fun getOrder(): ArrayList<FoodEntity> {
        return CurrentOrder.getState()?.getOrder() as ArrayList<FoodEntity>
    }
    fun addItem(food: FoodEntity){
        CurrentOrder.getState()?.onAdd(food)
    }
    fun Undo(){
        CurrentOrder.getState()?.onUndo(getOrder())
    }
    fun removeItem(food: FoodEntity){
        CurrentOrder.getState()?.onRemove(food)
    }

    fun processOrder(application: Application) {
        CurrentOrder.getState()?.onComplete(application)
    }
}