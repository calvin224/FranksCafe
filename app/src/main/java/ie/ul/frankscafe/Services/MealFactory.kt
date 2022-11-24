package ie.ul.frankscafe.Services

import ie.ul.frankscafe.Model.db_entity.Food
import ie.ul.frankscafe.repository.MealDealARepository
import ie.ul.frankscafe.repository.MealDealBRepository
import ie.ul.frankscafe.repository.MealDealCRepository

class MealFactory (){

    fun FoodFactory(food: Food) {

            if(food.foodType == "MealDealA"){
                MealDealARepository().addFood(food)
            } else if(food.foodType == "MealDealB"){
                MealDealBRepository().addFood(food)
            } else {
                MealDealCRepository().addFood(food)
            }
    }

    fun FoodFactoryEntity(food: Food) {
        if(food.foodType == "MealDealA"){
            MealDealARepository().addFood(food)
        } else if(food.foodType == "MealDealB"){
            MealDealBRepository().addFood(food)
        } else {
            MealDealCRepository().addFood(food)
        }
    }
}