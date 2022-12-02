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
import ie.ul.frankscafe.Services.CurrentUser
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
        addUser()
        userTypeCheck(CurrentUser.getuser())

        binding.signinbtn.setOnClickListener {

            fragmentManager.replaceFragment(Signin(application, fragmentManager))
            //notifyAllSubscribed()

        }

        binding.registerbtn.setOnClickListener {

            fragmentManager.replaceFragment(Register(application, fragmentManager))

        }

        binding.accountbtn.setOnClickListener {

            fragmentManager.replaceFragment(Account(application, fragmentManager))
            addUser2()

        }

        binding.orderbtn.setOnClickListener {

            fragmentManager.replaceFragment(Ordering(application, fragmentManager))

        }

        binding.ordersbtn.setOnClickListener {

            fragmentManager.replaceFragment(PastOrders(application, fragmentManager))

        }

        binding.pastorderbtn.setOnClickListener {

            fragmentManager.replaceFragment(AdminPastOrders(application, fragmentManager))

        }

        binding.adminaccountbtn.setOnClickListener {

            fragmentManager.replaceFragment(AdminAccount(application, fragmentManager))

        }

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
             val channel = NotificationChannel(channelID, "Customer Notification", android.app.NotificationManager.IMPORTANCE_DEFAULT)

             channel.enableVibration(true)
             notificationManager.createNotificationChannel(channel)
             builder.setChannelId(channelID)
         }
         val notification = builder.build()

         notificationManager.notify(1000, notification)
    }

    fun userTypeCheck(user: User) {
        if(user.usertype == 0){
            var fragmentContainer = R.id.fragment_container_user
            var fragmentManager = MainFragmentManager(supportFragmentManager, fragmentContainer)
            addUser()
        } else if(user.usertype == 1){
            var fragmentContainer = R.id.fragment_container_admin
            var fragmentManager = MainFragmentManager(supportFragmentManager, fragmentContainer)
            addUser()
        }
        else{
            var fragmentContainer = R.id.fragment_container
            var fragmentManager = MainFragmentManager(supportFragmentManager, fragmentContainer)
            addUser()
        }
    }
}