package ie.ul.frankscafe.Model.entity


class FoodEntity() {
    private var foodID: Int? = null
    private var foodName: String? = null
    private var foodPrice: Int? = null
    var foodType: FoodTypeEntity? = null


    //BUILDER PATTERN
    class Builder {
        private var foodID: Int? = null
        private var foodName: String? = null
        private var foodPrice: Int? = null
        var foodType: FoodTypeEntity? = null

        fun setFoodId(foodID: Int?): Builder {
            this.foodID = foodID
            return this
        }

        fun setFoodName(foodName: String?): Builder {
            this.foodName = foodName
            return this
        }

        fun setFoodPrice(foodPrice: Int?): Builder {
            this.foodPrice = foodPrice
            return this
        }

        fun setFoodType(foodType: FoodTypeEntity?): Builder {
            this.foodType = foodType
            return this
        }

        fun build(): FoodEntity {
            val foodentity = FoodEntity()
            foodentity.foodID = foodID
            foodentity.foodName = foodName
            foodentity.foodPrice = foodPrice
            foodentity.foodType = foodType
            return foodentity
        }
    }

    fun getFoodId(): Int? {
        return foodID
    }

    fun getFoodName(): String? {
        return foodName
    }

    fun getFoodPrice(): Int? {
        return foodPrice
    }

    fun getFoodEntityType(): FoodTypeEntity? {
        return foodType
    }
}



