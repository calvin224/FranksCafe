package ie.ul.frankscafe.Services

import android.app.Application
import ie.ul.frankscafe.Model.db_entity.User
import ie.ul.frankscafe.Model.entity.UserEntity
import ie.ul.frankscafe.repository.UserRepository

//Singleton
object CurrentUser {
    lateinit var user : User
    fun init(inuser: User, application: Application) {
        var usertemp = inuser
        UserEntity.Builder().setUserId(usertemp.userId)
        UserEntity.Builder().setEmail(usertemp.email)
        UserEntity.Builder().setUsername(usertemp.username)
        UserEntity.Builder().setUserType(usertemp.usertype)
        UserEntity.Builder().setUserSubscribedStatus(usertemp.isSubscribed)
        UserEntity.Builder().build()
        user = inuser
    }

    fun getuser(): User {
        return user
    }
    fun clear(){
         user = null!!
    }

}

