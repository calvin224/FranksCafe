package ie.ul.frankscafe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ie.ul.frankscafe.Model.db_entity.User
import ie.ul.frankscafe.Model.entity.UserEntity
import ie.ul.frankscafe.ViewModel.UserViewModel

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        UserEntity.Builder().setPassword("123")
        UserEntity.Builder().setUserId(1)
        UserEntity.Builder().setUsername("calvin")
        UserEntity.Builder().setUserType(1)
        var user = UserEntity.Builder().build()
        var usertest = User(12,"calvin","123",1)
        UserViewModel(application).addUser(usertest)


    }
}
