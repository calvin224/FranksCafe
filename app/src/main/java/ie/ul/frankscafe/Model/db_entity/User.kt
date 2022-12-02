package ie.ul.frankscafe.Model.db_entity

import EmailService
import android.app.Application
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import ie.ul.frankscafe.Services.EmailNotification
import ie.ul.frankscafe.Services.NoPreference
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.mail.internet.InternetAddress
import ie.ul.frankscafe.Services.NotificationStrategy
import ie.ul.frankscafe.Services.PushNotification

@Entity(tableName = "Users")
data class User(
    @PrimaryKey(autoGenerate = true) var userId: Int?,
    @ColumnInfo(name = "username") var username: String?,
    @ColumnInfo(name = "email") var email: String?,
    @ColumnInfo(name = "password") var password: String?,
    @ColumnInfo(name = "userType") var usertype: Int?,
    @ColumnInfo(name = "isSubscribed") var isSubscribed: Int?,
    @ColumnInfo(name = "userNotificationPreference") var userNotificationPreference: Int?
)
{
        fun notifyUser(notificationPreference: Int, dailyDeal: String, application: Application) {
            var notificationType: NotificationStrategy = NoPreference()
            when (notificationPreference) {
                0 -> notificationType = NoPreference()

                1 -> notificationType = PushNotification()

                2 -> notificationType = EmailNotification()

                else -> notificationType = NoPreference()
            }
            notificationType?.notifyUser(dailyDeal, application)
        }
    }