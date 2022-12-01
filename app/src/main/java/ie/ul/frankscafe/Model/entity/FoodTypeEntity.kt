package ie.ul.frankscafe.Model.entity

class FoodTypeEntity(foodType: String, mealDeal: String) {
    private val foodType: String? = null
    private val mealDeal: String? = null

    fun getFoodType(): String?{
        return foodType
    }

    fun getMealDeal(): String?{
        return mealDeal
    }
}