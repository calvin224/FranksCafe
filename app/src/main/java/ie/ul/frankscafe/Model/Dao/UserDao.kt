package ie.ul.frankscafe.Model.Dao

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
     fun findbyUsername(username: String?) : User

    @Query("SELECT * from Users WHERE isSubscribed = 1")
    fun getAllSubscribed(): List<User>

    @Query("SELECT * FROM Users WHERE username LIKE :username AND  password LIKE :password")
    fun findbyUsernameAndPassword(username: String,password :String) : User

}

