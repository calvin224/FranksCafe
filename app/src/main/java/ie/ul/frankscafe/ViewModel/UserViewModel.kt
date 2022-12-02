package ie.ul.frankscafe.ViewModel

import android.app.Application
import androidx.lifecycle.*
import ie.ul.frankscafe.Model.db.AppDatabase
import ie.ul.frankscafe.Model.db_entity.User
import ie.ul.frankscafe.Services.CurrentUser
import ie.ul.frankscafe.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class UserViewModel(application: Application): AndroidViewModel(application) {
     val getAll : List<User>
     val repository: UserRepository

    init {
        val userDao = AppDatabase.getDatabase(application).UserDao()
        repository = UserRepository(application)
        getAll = repository.getAll
    }

    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO){
            repository.addUser(user)
        }
    }

    fun findbyusername(username: String): User {
        var temp = repository.findbyusername(username)
        return temp
    }

    fun login(username: String?, application: Application){
        CurrentUser.init(username,application)
    }

    fun register(user: User){
        GlobalScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }
}
