package ie.ul.frankscafe.repository

import androidx.lifecycle.LiveData
import ie.ul.frankscafe.Model.Dao.UserDao
import ie.ul.frankscafe.Model.db_entity.User

class UserRepository(private val userDao: UserDao) {
    val getAll: LiveData<List<User>> = userDao.getAll()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }
}