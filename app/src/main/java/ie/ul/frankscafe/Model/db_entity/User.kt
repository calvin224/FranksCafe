package ie.ul.frankscafe.Model.db_entity

import EmailService
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
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
)
{
        fun notifyUser(dailyDeal: String) {
            val auth = EmailService.UserPassAuthenticator("frankscafenotification@gmail.com", "mysrystwvdlxtvbm")
            val to = listOf(InternetAddress(this.email))
            val from = InternetAddress("frankscafenotification@gmail.com")
            val email = EmailService.Email(auth, to, from, "Test Subject", dailyDeal)
            val emailService = EmailService("smtp.gmail.com", 587)

            GlobalScope.launch {
                emailService.send(email)
            }
        }
    }