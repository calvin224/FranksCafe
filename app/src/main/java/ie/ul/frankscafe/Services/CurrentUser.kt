package ie.ul.frankscafe.Services

import android.app.Application
import ie.ul.frankscafe.Model.entity.UserEntity
import ie.ul.frankscafe.repository.UserRepository

//Singleton
object CurrentUser {

    fun init(username: String?, application: Application) {
        var usertemp = UserRepository(application).findbyusername(username)
        UserEntity.Builder().setUserId(usertemp.userId)
        UserEntity.Builder().setUsername(usertemp.username)
        UserEntity.Builder().setUserType(usertemp.usertype)
        UserEntity.Builder().setUserSubscribedStatus(usertemp.isSubscribed)
        UserEntity.Builder().build()
    }

    fun getuser(): UserEntity.Builder {
        return UserEntity.Builder()
    }
//    fun clear(){
////         user = null!!
//    }
}

