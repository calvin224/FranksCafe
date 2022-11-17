package ie.ul.frankscafe.repository

import ie.ul.frankscafe.Model.db_entity.Food

class MealDealBRepository() {
    val MealDealB = ArrayList<Food>()

    fun addFood(food: Food){
        MealDealB.add(food)
    }

}