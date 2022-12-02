package ie.ul.frankscafe.Services

import android.app.Application
import ie.ul.frankscafe.Model.Dao.UserDao
import ie.ul.frankscafe.Model.db.AppDatabase
import ie.ul.frankscafe.Model.db_entity.User
import ie.ul.frankscafe.Model.entity.UserEntity
import ie.ul.frankscafe.repository.UserRepository

//Singleton
object CurrentUser {
    var user : UserEntity.Builder = null!!

    fun init(username: String,application: Application) {
        var usertemp = UserRepository(application).findbyusername(username)
        user.setUserId(usertemp.userId)
        user.setUsername(usertemp.username)
        user.setUserType(usertemp.usertype)
        user.setUserSubscribedStatus(usertemp.isSubscribed)
        user.build()
    }

    fun getuser(): UserEntity.Builder {
        return user
    }
    fun clear(){
         user = null!!
    }

}

