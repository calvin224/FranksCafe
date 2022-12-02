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
        currentUser = User(usertemp.userId, usertemp.username, usertemp.email, usertemp.password, usertemp.usertype, usertemp.isSubscribed)
    }

    fun getuser(): User {
        return currentUser
    }
//    fun clear(){
////         user = null!!
//    }
}

