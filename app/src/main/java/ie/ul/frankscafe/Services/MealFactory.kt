package ie.ul.frankscafe.Services

import ie.ul.frankscafe.Model.db_entity.Food
import ie.ul.frankscafe.Model.entity.FoodEntity
import ie.ul.frankscafe.repository.MealDealARepository
import ie.ul.frankscafe.repository.MealDealBRepository
import ie.ul.frankscafe.repository.MealDealCRepository

class MealFactory (){

    fun FoodFactory(food: FoodEntity) {

            if(food.foodType?.getMealDeal() == "MealDealA"){
                MealDealARepository().addFood(food)
            } else if(food.foodType?.getMealDeal() == "MealDealB"){
                MealDealBRepository().addFood(food)
            } else {
                MealDealCRepository().addFood(food)
            }
    }

    fun FoodFactoryEntity(food: FoodEntity) {
        if(food.foodType?.getMealDeal() == "MealDealA"){
            MealDealARepository().addFood(food)
        } else if(food.foodType?.getMealDeal() == "MealDealB"){
            MealDealBRepository().addFood(food)
        } else {
            MealDealCRepository().addFood(food)
        }
    }
}