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

    @Query("SELECT * from PastOrders WHERE orderID like :id")
    fun getOrder(id : Int): List<PastOrder>

    @Query("SELECT * FROM PastOrders ORDER BY orderID DESC LIMIT 1")
    fun getLastOrderID(): Int

    @Query("SELECT * from PastOrders WHERE CustomerID like :customerID")
    fun getAllOrdersByCustomerID(customerID: Int): List<PastOrder>
}