package ie.ul.frankscafe.Services

import EmailService
import android.annotation.SuppressLint
import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.getSystemService
import ie.ul.frankscafe.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.mail.internet.InternetAddress

interface NotificationStrategy {
    fun notifyUser(dailyDeal: String, application: Application)
}

class EmailNotification : NotificationStrategy {
    override fun notifyUser(dailyDeal: String, application: Application) {
        val auth = EmailService.UserPassAuthenticator("frankscafenotification@gmail.com", "mysrystwvdlxtvbm")
        val to = listOf(InternetAddress(CurrentUser.getuser().email))
        val from = InternetAddress("frankscafenotification@gmail.com")
        val email = EmailService.Email(auth, to, from, "Test Subject", dailyDeal)
        val emailService = EmailService("smtp.gmail.com", 587)

        GlobalScope.launch {
            emailService.send(email)
        }
    }
}

class PushNotification : NotificationStrategy {
    override fun notifyUser(dailyDeal: String, application: Application) {
        var applicationContext = application.applicationContext
        @SuppressLint("ServiceCast")
            val channelID = "100"
            val notificationManager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            val builder = NotificationCompat.Builder(applicationContext,channelID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentText("Daily Deal Updated!")
                .setContentTitle("New Deal Category: $dailyDeal")

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                val channel = NotificationChannel(channelID, "Custom Notification", NotificationManager.IMPORTANCE_DEFAULT)

                channel.enableVibration(true)
                notificationManager.createNotificationChannel(channel)
                builder.setChannelId(channelID)
            }
            val notification = builder.build()

            notificationManager.notify(1000, notification)
    }
}
class NoPreference : NotificationStrategy {
    override fun notifyUser(dailyDeal: String, application: Application) {
    }
}
