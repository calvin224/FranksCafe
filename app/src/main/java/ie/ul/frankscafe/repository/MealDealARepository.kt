package ie.ul.frankscafe.repository

import ie.ul.frankscafe.Model.entity.FoodEntity

class MealDealARepository() {
    val MealDealA = ArrayList<FoodEntity>()


    fun addFood(food: FoodEntity){
        MealDealA.add(food)
    }
}


