package ie.ul.frankscafe.repository

import ie.ul.frankscafe.Model.Dao.UserDao
import ie.ul.frankscafe.Model.db_entity.User

class UserRepository(private val userDao: UserDao) {
    val getAll: List<User> = userDao.getAll()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }

    fun findbyusername(username: String): User {
        return userDao.findbyUsername(username)
    }
}