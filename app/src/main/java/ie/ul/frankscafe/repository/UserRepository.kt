package ie.ul.frankscafe.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ie.ul.frankscafe.Model.Dao.UserDao
import ie.ul.frankscafe.Model.db_entity.User
import ie.ul.frankscafe.Model.entity.UserEntity

class UserRepository(private val userDao: UserDao) {
    val getAll: List<User> = userDao.getAll()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }
}