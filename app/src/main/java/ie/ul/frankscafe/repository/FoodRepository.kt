package ie.ul.frankscafe.repository

import ie.ul.frankscafe.Model.Dao.FoodDao
import ie.ul.frankscafe.Model.db_entity.Food
import ie.ul.frankscafe.Model.entity.FoodEntity
import ie.ul.frankscafe.Model.entity.FoodTypeEntity
import ie.ul.frankscafe.Services.FoodFactory


class FoodRepository(private val foodDao: FoodDao) {

    private var allFoods: MutableList<FoodEntity> = ArrayList()

    fun readFromDB(): ArrayList<List<String>>{
        var foodsArr: ArrayList<List<String>> = ArrayList()
        var foods = foodDao.readAll()
        for (food: String in foods) {
            foodsArr.add(food.split(","))
        }
        return foodsArr
    }

    fun generateFoodEntity(foodID: Int, foodName: String, foodType: String, mealDeal: String, foodPrice: Double) {
        val foodTypeEntity: FoodTypeEntity? = FoodFactory().getFoodType(foodType, mealDeal)
        var tempFoodEntity = FoodEntity.Builder()
        tempFoodEntity.setFoodId(foodID)
        tempFoodEntity.setFoodName(foodName)
        tempFoodEntity.setFoodPrice(foodPrice)
        tempFoodEntity.setFoodType(foodTypeEntity)
        allFoods.add(tempFoodEntity.build())
    }

    fun getAll(): MutableList<FoodEntity>{
        for (food in readFromDB()){
            generateFoodEntity(food[0].toInt(), food[1], food[2], food[3], food[4].toDouble())
        }
        return allFoods
    }

    fun getAllFoodsByMealDeal(mealDeal: String): List<FoodEntity>{
        var allFoodEntities = allFoods
        var allFoodNamesPrices: MutableList<FoodEntity> = ArrayList()
        for (food in allFoodEntities){
            if (food.getFoodEntityType()?.getMealDeal().equals(mealDeal) ){
                allFoodNamesPrices.add(food)
            }
        }
        return allFoodNamesPrices
    }

    fun getFoodByName(foodName: String): FoodEntity{
        var allFoodEntities = allFoods
        var foodEntity = FoodEntity()
        for (food in allFoodEntities){
            if (food.getFoodName().equals(foodName) ){
                foodEntity = food
            }
        }
        return foodEntity
    }

    suspend fun addFood(food: Food){
        foodDao.addFood(food)
    }
}