package ie.ul.frankscafe.Model.Dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ie.ul.frankscafe.Model.db_entity.User

@Dao
interface UserDao {
    @Query("SELECT * from Users")
    fun getAll(): List<User>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Query("SELECT * FROM Users WHERE username LIKE :username")
     fun findbyUsername(username: String) : User

}