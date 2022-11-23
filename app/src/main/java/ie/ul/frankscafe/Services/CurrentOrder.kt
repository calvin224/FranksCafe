package ie.ul.frankscafe.Services

import android.content.Context
import ie.ul.frankscafe.Model.db_entity.Food

//Singleton
object CurrentOrder {
    var Order: ArrayList<Food> = emptyList<Food>() as ArrayList<Food>

    fun addItem(food: Food) {
        Order.add(food)
    }
    fun removeItem(food: Food) {
        Order.remove(food)
    }
    fun getOrders(): ArrayList<Food> {
            return Order
    }
}
