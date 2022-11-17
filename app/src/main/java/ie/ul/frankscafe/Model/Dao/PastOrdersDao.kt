package ie.ul.frankscafe.Model.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ie.ul.frankscafe.Model.db_entity.PastOrder
import ie.ul.frankscafe.Model.db_entity.User

@Dao
interface PastOrdersDao {
    @Query("SELECT * from PastOrders")
    fun getAll(): List<PastOrder>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addOrder(order: PastOrder)
}