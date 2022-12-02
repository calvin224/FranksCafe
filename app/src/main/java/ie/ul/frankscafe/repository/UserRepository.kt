package ie.ul.frankscafe.repository

import android.app.Application
import ie.ul.frankscafe.Model.db.AppDatabase
import ie.ul.frankscafe.Model.db_entity.User
import ie.ul.frankscafe.Services.NotificationStrategy
import ie.ul.frankscafe.Services.CalcOrder

class UserRepository(application: Application) {
    val userDao = AppDatabase.getDatabase(application).UserDao()
    val getAll: List<User> = userDao.getAll()
    val application = application

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }

    fun findbyusername(username: String?): User {
        return userDao.findbyUsername(username)
    }

    fun checkValidUser(username: String, password: String): Boolean{
        return userDao.findbyUsernameAndPassword(username,password) != null
    }

    fun login(username: String,password: String): User {
        return userDao.findbyUsernameAndPassword(username,password)
    }

    fun getAllSubscribed(): List<User> {
        return userDao.getAllSubscribed()
    }

    fun notifyAllSubscribed(dailyDeal: String){
        var subscribedUsers = getAllSubscribed()
        for (user in subscribedUsers){
            user.notifyUser(user.userNotificationPreference as Int, dailyDeal, application)
        }
    }

    fun getTotalCost(): Double {
        return  CalcOrder().GetTotalCost()
    }
}