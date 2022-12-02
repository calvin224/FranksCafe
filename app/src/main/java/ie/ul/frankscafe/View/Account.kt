package ie.ul.frankscafe.View

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.ToggleButton
import androidx.appcompat.widget.AppCompatButton
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import ie.ul.frankscafe.R
import ie.ul.frankscafe.Services.CurrentUser
import ie.ul.frankscafe.databinding.ActivityMainBinding

class Account(val application: Application, val mainFragmentManager: MainFragmentManager) : Fragment(R.layout.account){

    lateinit var binding: ActivityMainBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.account, container, false)
        val regButton = view.findViewById<AppCompatButton>(R.id.pastorders)
        val notificationButton = view.findViewById<AppCompatButton>(R.id.notificationButton)
        val toggle = view.findViewById<Switch>(R.id.notificationToggle)
        //val user = CurrentUser.getuser()

        regButton.setOnClickListener{
            mainFragmentManager.replaceFragment(PastOrders(application, mainFragmentManager))
        }

        toggle.setOnCheckedChangeListener { _, isChecked ->  //toggles notifications for current user
            if (isChecked) {
                CurrentUser.getuser().isSubscribed = 1
            } else {
                CurrentUser.getuser().isSubscribed = 0
            }
        }

        /*notificationButton.setOnClickListener {
            (activity as MainActivity).showNotification()
        }*/

/*        @SuppressLint("ServiceCast")
        fun showNotification(){
            val channelID = "100"
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            val builder = NotificationCompat.Builder(applicationContext,channelID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentText("Example Text")
                .setContentTitle("Example Title")

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                val channel = NotificationChannel(channelID, "Custome Notification", NotificationManager.IMPORTANCE_DEFAULT)

                channel.enableVibration(true)
                notificationManager.createNotificationChannel(channel)
                builder.setChannelId(channelID)
            }
            val notification = builder.build()

            notificationManager.notify(1000, notification)
        }*/

        return view
    }

}
