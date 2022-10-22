package ie.ul.frankscafe.ViewModel

import android.app.Application
import androidx.lifecycle.*
import ie.ul.frankscafe.Model.db.AppDatabase
import ie.ul.frankscafe.Model.db_entity.Food
import ie.ul.frankscafe.Model.entity.FoodEntity
import ie.ul.frankscafe.repository.FoodRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class FoodViewModel(application: Application): AndroidViewModel(application) {
     val getAll : List<Food>
     val repository: FoodRepository

    init {
        val foodDao = AppDatabase.getDatabase(application).FoodDao()
        repository = FoodRepository(foodDao)
        getAll = repository.getAll
    }


    fun addFood(food: Food){
        viewModelScope.launch(Dispatchers.IO){
            repository.addFood(food)
        }
    }



}