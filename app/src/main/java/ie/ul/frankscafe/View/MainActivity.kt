package ie.ul.frankscafe.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import ie.ul.frankscafe.Model.db_entity.User
import ie.ul.frankscafe.R
import ie.ul.frankscafe.Services.CurrentOrder
import ie.ul.frankscafe.ViewModel.FoodViewModel
import ie.ul.frankscafe.ViewModel.UserViewModel
import ie.ul.frankscafe.databinding.ActivityMainBinding
import ie.ul.frankscafe.repository.NotificationManager
import ie.ul.frankscafe.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

open class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addUser()

        binding.fragment1btn.setOnClickListener {

            replaceFragment(Signin())
            notifyAllSubscribed()

        }

        binding.fragment2btn.setOnClickListener {

            replaceFragment(Register(application))

        }

        binding.fragment3btn.setOnClickListener {

            replaceFragment(Account())
            addUser2()

        }

        binding.fragment5btn.setOnClickListener {

            replaceFragment(Ordering())

        }

        binding.fragment6btn.setOnClickListener {

            replaceFragment(PastOrders())

        }



 }
    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }

    private fun notifyAllSubscribed(){
       var user = NotificationManager(application)
        user.updateDeal("Test")
    }

    fun addUser() {
        val user = User(99, "calvin23", "frankscafenotification@gmail.com", "1", 1, 1)
        GlobalScope.launch(Dispatchers.IO) {
            UserViewModel(application).addUser(user)
        }
    }
    fun addUser2() {
        val user = User(992, "calvin232", "franom", "123", 1, 1)
        GlobalScope.launch(Dispatchers.IO) {
            UserViewModel(application).addUser(user)
        }
    }
}


