package ie.ul.frankscafe.repository

import ie.ul.frankscafe.Model.db_entity.Food

class MealDealCRepository() {
    val MealDealC = ArrayList<Food>()

    fun addFood(food: Food){
        MealDealC.add(food)
    }
}