package ie.ul.frankscafe.repository

import ie.ul.frankscafe.Model.entity.FoodEntity

class MealDealBRepository() {
    val MealDealB = ArrayList<FoodEntity>()

    fun addFood(food: FoodEntity){
        MealDealB.add(food)
    }

}