package ie.ul.frankscafe.Services

import android.content.Context
import ie.ul.frankscafe.Model.db_entity.Food

//Singleton
object CurrentOrder {
    var Order: ArrayList<Food> = emptyList<Food>() as ArrayList<Food>
    val originator = Originator(Food(0,"initial state",""))
    val careTaker = Caretaker()


    fun addItem(food: Food) {
        Order.add(food)
        originator.state = food
        careTaker.saveState(originator.createMemento())
    }
    fun removeItem(food: Food) {
        Order.remove(food)
    }
    fun getOrders(): ArrayList<Food> {
            return Order
    }

    fun Undo(foodlist : ArrayList<Food>){
        originator.restore(careTaker.restore(foodlist.size))
    }
}
