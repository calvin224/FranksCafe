package ie.ul.frankscafe.Model.entity

class FoodTypeEntity constructor(foodType: String, mealDeal: String) {
    private var foodType: String? = null
    private var mealDeal: String? = null

    init{
        this.foodType = foodType
        this.mealDeal = mealDeal
    }

    fun getFoodType(): String?{
        return foodType
    }

    fun getMealDeal(): String?{
        return mealDeal
    }
}