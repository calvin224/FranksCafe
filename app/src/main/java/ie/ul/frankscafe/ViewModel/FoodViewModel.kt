package ie.ul.frankscafe.ViewModel

import android.app.Application
import androidx.lifecycle.*
import ie.ul.frankscafe.Model.db.AppDatabase
import ie.ul.frankscafe.Model.db_entity.Food
import ie.ul.frankscafe.repository.FoodRepository
import ie.ul.frankscafe.Services.MealFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class FoodViewModel(application: Application): AndroidViewModel(application) {
     val getAll : List<Food>
     val foodrepository: FoodRepository
     val mealFactory: MealFactory

    init {
        val foodDao = AppDatabase.getDatabase(application).FoodDao()
        foodrepository = FoodRepository(foodDao)
        getAll = foodrepository.getAll
        mealFactory = MealFactory()
        for (i in getAll){
            mealFactory.FoodFactory(i)
        }
    }

    fun addFood(food: Food){
        viewModelScope.launch(Dispatchers.IO){
            foodrepository.addFood(food)
        }
    }


}