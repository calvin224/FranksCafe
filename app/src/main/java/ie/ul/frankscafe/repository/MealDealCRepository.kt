package ie.ul.frankscafe.repository

import ie.ul.frankscafe.Model.entity.FoodEntity

class MealDealCRepository() {
    val MealDealC = ArrayList<FoodEntity>()

    fun addFood(food: FoodEntity){
        MealDealC.add(food)
    }
}