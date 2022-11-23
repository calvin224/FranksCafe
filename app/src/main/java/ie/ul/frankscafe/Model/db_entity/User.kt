package ie.ul.frankscafe.Model.db_entity

import android.app.Application
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ie.ul.frankscafe.Services.EmailNotificationDecorator
import ie.ul.frankscafe.Services.Notification
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.mail.internet.InternetAddress


@Entity(tableName = "Users")
data class User(
    @PrimaryKey(autoGenerate = true) var userId: Int?,
    @ColumnInfo(name = "username") var username: String?,
    @ColumnInfo(name = "email") var email: String?,
    @ColumnInfo(name = "password") var password: String?,
    @ColumnInfo(name = "userType") var usertype: Int?,
    @ColumnInfo(name = "isSubscribed") var isSubscribed: Int?
) {
    fun notifyUser(dailyDeal: String,application: Application) {
        val notification = EmailNotificationDecorator(Notification(),application)
        val auth = EmailNotificationDecorator.UserPassAuthenticator("frankscafenotification@gmail.com", "mysrystwvdlxtvbm")
        val to = listOf(InternetAddress(this.email))
        val from = InternetAddress("frankscafenotification@gmail.com")
        val email = EmailNotificationDecorator.Email(auth, to, from, "Test Subject", dailyDeal)
        GlobalScope.launch {
            notification.send(email)
        }
    }
}