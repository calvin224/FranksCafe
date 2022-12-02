package ie.ul.frankscafe.Services

import android.app.Application
import ie.ul.frankscafe.Model.db_entity.User
import ie.ul.frankscafe.Model.entity.UserEntity
import ie.ul.frankscafe.repository.UserRepository

//Singleton
object CurrentUser {
    lateinit var currentUser: User
    fun init(username: String?, application: Application) {
        var usertemp = UserRepository(application).findbyusername(username)
        UserEntity.Builder().setUserId(usertemp.userId)
        UserEntity.Builder().setEmail(usertemp.email)
        UserEntity.Builder().setUsername(usertemp.username)
        UserEntity.Builder().setUserType(usertemp.usertype)
        UserEntity.Builder().setUserSubscribedStatus(usertemp.isSubscribed)
        UserEntity.Builder().build()
        currentUser = User(usertemp.userId, usertemp.username, usertemp.email, usertemp.password, usertemp.usertype, usertemp.isSubscribed)
    }

    fun getuser(): User {
        return currentUser
    }
    fun clear(){
        currentUser = User(-1, "", "", "", 0, 0)
   }
}

