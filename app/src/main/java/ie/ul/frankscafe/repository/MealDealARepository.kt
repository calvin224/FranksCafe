package ie.ul.frankscafe.repository

import ie.ul.frankscafe.Model.db_entity.Food

class MealDealARepository() {
    val MealDealA = ArrayList<Food>()


    fun addFood(food: Food){
        MealDealA.add(food)
    }
}

