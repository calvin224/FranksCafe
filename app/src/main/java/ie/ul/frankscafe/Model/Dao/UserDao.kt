package ie.ul.frankscafe.Model.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ie.ul.frankscafe.Model.db_entity.User

@Dao
interface UserDao {
    @Query("SELECT * from Users")
    fun getAll(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

}