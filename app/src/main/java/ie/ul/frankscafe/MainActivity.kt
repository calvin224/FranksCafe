package ie.ul.frankscafe

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import ie.ul.frankscafe.Model.db.AppDatabase
import ie.ul.frankscafe.Model.db_entity.User
import ie.ul.frankscafe.Model.entity.UserEntity
import ie.ul.frankscafe.ViewModel.UserViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addUser()
        ReadAll()

 }

    fun addUser(){
        val user = User(99,"calvin23","123",1)
        GlobalScope.launch(Dispatchers.IO) {
            UserViewModel(application).addUser(user)
        }

        }

    fun ReadAll(){
        GlobalScope.launch(Dispatchers.IO) {
            val textView : TextView = findViewById(R.id.textView) as TextView
            textView.setText(UserViewModel(application).getAll.get(0).password)
        }
    }
}


