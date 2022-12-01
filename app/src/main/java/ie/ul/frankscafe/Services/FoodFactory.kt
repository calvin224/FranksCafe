package ie.ul.frankscafe.Services

import ie.ul.frankscafe.Model.entity.FoodTypeEntity

class FoodFactory {
    private val foodTypes: MutableMap<String, FoodTypeEntity?> = HashMap()

    fun getFoodType(foodType: String, mealDeal: String): FoodTypeEntity? {
        if (foodTypes[foodType] == null) {
            foodTypes[foodType] = FoodTypeEntity(foodType, mealDeal)
        }
        return foodTypes[foodType]
    }
}