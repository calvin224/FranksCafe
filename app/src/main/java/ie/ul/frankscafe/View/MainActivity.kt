package ie.ul.frankscafe.View

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.TextView
import androidx.fragment.app.Fragment
import ie.ul.frankscafe.Model.db_entity.User
import ie.ul.frankscafe.R
import ie.ul.frankscafe.Services.CurrentOrder
import ie.ul.frankscafe.Services.EmailNotification
import ie.ul.frankscafe.ViewModel.FoodViewModel
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
        var fragmentContainer = R.id.fragment_container
        var fragmentManager = MainFragmentManager(supportFragmentManager, fragmentContainer)


        binding.fragment1btn.setOnClickListener {

            fragmentManager.replaceFragment(Signin(application, fragmentManager))

        }

        binding.fragment2btn.setOnClickListener {

            fragmentManager.replaceFragment(Register(application, fragmentManager))

        }

        binding.fragment3btn.setOnClickListener {

            fragmentManager.replaceFragment(Account(application, fragmentManager))

        }

        binding.fragment4btn.setOnClickListener {

            fragmentManager.replaceFragment(Ordering(application, fragmentManager))

        }

        binding.fragment5btn.setOnClickListener {

            fragmentManager.replaceFragment(PastOrders(application, fragmentManager))
            notifyAllSubscribed()

        }
 }

    private fun notifyAllSubscribed(){
       var user = localNotificationManager(application)
        user.updateDeal("Mexican")
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
             val channel = NotificationChannel(channelID, "Custom Notification", android.app.NotificationManager.IMPORTANCE_DEFAULT)

             channel.enableVibration(true)
             notificationManager.createNotificationChannel(channel)
             builder.setChannelId(channelID)
         }
         val notification = builder.build()

         notificationManager.notify(1000, notification)
    }
}