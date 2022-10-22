package ie.ul.frankscafe.Model.entity


class FoodEntity() {
    private var foodID: Int? = null
    private var foodName: String? = null
    private var foodType: String? = null


    //BUILDER PATTERN
    class Builder {
        private var foodID: Int? = null
        private var foodName: String? = null
        private var foodType: String? = null

        fun setFoodId(foodID: Int?): Builder {
            this.foodID = foodID
            return this
        }

        fun setFoodName(foodName: String?): Builder {
            this.foodName = foodName
            return this
        }

        fun setFoodType(foodType: String?): Builder {
            this.foodType = foodType
            return this
        }

        fun build(): FoodEntity {
            val foodentity = FoodEntity()
            foodentity.foodID = foodID
            foodentity.foodName = foodName
            foodentity.foodType = foodType
            return foodentity
        }
    }
}



