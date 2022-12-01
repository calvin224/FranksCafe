package ie.ul.frankscafe.Services

import ie.ul.frankscafe.Model.db_entity.Food
import ie.ul.frankscafe.repository.MealDealARepository
import ie.ul.frankscafe.repository.MealDealBRepository
import ie.ul.frankscafe.repository.MealDealCRepository

class MealFactory (){

    fun FoodFactory(food: Food) {

            if(food.foodType == "A"){
                MealDealARepository().addFood(food)
            } else if(food.foodType == "B"){
                MealDealBRepository().addFood(food)
            } else {
                MealDealCRepository().addFood(food)
            }
    }

}