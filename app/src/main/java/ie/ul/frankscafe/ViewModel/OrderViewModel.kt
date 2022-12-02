package ie.ul.frankscafe.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import ie.ul.frankscafe.Model.db_entity.Food
import ie.ul.frankscafe.Services.CurrentOrder

class OrderViewModel(application: Application): AndroidViewModel(application)
{
    fun getOrder(): ArrayList<Food>? {
        return CurrentOrder.getState()?.getOrder()
    }
    fun addItem(food: Food){
        CurrentOrder.getState()?.onAdd(food)
    }
    fun Undo(){
        CurrentOrder.getState()?.onUndo(getOrder())
    }
    fun removeItem(food: Food){
        CurrentOrder.getState()?.onRemove(food)
    }
    fun getState() {
        CurrentOrder.getState()
    }
    fun processOrder(application: Application){
        CurrentOrder.getState()?.onComplete(application)
    }
}