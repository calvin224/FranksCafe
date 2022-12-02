package ie.ul.frankscafe.View

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import ie.ul.frankscafe.Model.db_entity.User
import ie.ul.frankscafe.R
import ie.ul.frankscafe.ViewModel.UserViewModel
import ie.ul.frankscafe.databinding.ActivityMainBinding
import android.app.NotificationManager
import ie.ul.frankscafe.repository.NotificationManager as localNotificationManager
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

            replaceFragment(Signin(application))
            //notifyAllSubscribed()

        }

        binding.fragment2btn.setOnClickListener {

            replaceFragment(Register(application))

        }

        binding.fragment3btn.setOnClickListener {

            replaceFragment(Account())
            addUser2()

        }

        binding.fragment4btn.setOnClickListener {

            replaceFragment(Ordering())

        }

        binding.fragment5btn.setOnClickListener {

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
       var user = localNotificationManager(application)
        user.updateDeal("Test")
    }

    fun addUser() {
        GlobalScope.launch(Dispatchers.IO) {
        }
    }
    fun addUser2() {
        val user = User(992, "calvin232", "franom", "123", 1, 1)
        GlobalScope.launch(Dispatchers.IO) {
            UserViewModel(application).addUser(user)
        }
    }

     @SuppressLint("ServiceCast")
     fun showNotification(){
         val channelID = "100"
         val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

         val builder = NotificationCompat.Builder(applicationContext,channelID)
             .setSmallIcon(R.drawable.ic_launcher_background)
             .setContentText("Example Text")
             .setContentTitle("Example Title")

         if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
             val channel = NotificationChannel(channelID, "Custome Notification", android.app.NotificationManager.IMPORTANCE_DEFAULT)

             channel.enableVibration(true)
             notificationManager.createNotificationChannel(channel)
             builder.setChannelId(channelID)
         }
         val notification = builder.build()

         notificationManager.notify(1000, notification)
    }
}