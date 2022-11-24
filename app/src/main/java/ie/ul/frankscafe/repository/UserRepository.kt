package ie.ul.frankscafe.repository

import android.app.Application
import ie.ul.frankscafe.Model.Dao.UserDao
import ie.ul.frankscafe.Model.db.AppDatabase
import ie.ul.frankscafe.Model.db_entity.User

class UserRepository(application: Application) {
    val userDao = AppDatabase.getDatabase(application).UserDao()
    val getAll: List<User> = userDao.getAll()
    val application = application

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }

    fun findbyusername(username: String): User {
        return userDao.findbyUsername(username)
    }

    fun getAllSubscribed(): List<User> {
        return userDao.getAllSubscribed()
    }

    fun notifyAllSubscribed(dailyDeal: String){
        var subscribedUsers = getAllSubscribed()
        for (user in subscribedUsers){
            user.notifyUser(dailyDeal)
        }
    }
}