package ie.ul.frankscafe.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ie.ul.frankscafe.Model.Dao.FoodDao
import ie.ul.frankscafe.Model.db_entity.Food
import ie.ul.frankscafe.Model.entity.FoodEntity

class FoodRepository(private val foodDao: FoodDao) {
    val getAll: List<Food> = foodDao.getAll()

    suspend fun addFood(food: Food){
        foodDao.addFood(food)
    }
}