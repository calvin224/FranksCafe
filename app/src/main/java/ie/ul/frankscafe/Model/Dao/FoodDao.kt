package ie.ul.frankscafe.Model.Dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ie.ul.frankscafe.Model.db_entity.Food

@Dao
interface FoodDao {
    @Query("SELECT * from Foods")
    fun getAll(): List<Food>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFood(food: Food)

    @Query("SELECT foodID||','||foodName||','||foodType||','||mealDeal||','||foodPrice FROM Foods")
    fun readAll(): List<String>
}