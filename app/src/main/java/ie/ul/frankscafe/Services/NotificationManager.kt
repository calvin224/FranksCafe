package ie.ul.frankscafe.Services

import EmailService
import android.app.Application
import ie.ul.frankscafe.repository.UserRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.mail.internet.InternetAddress

class NotificationManager(val application: Application) {

    val repository = UserRepository(application)

    fun updateDeal(dailyDeal: String){

        repository.notifyAllSubscribed(dailyDeal)
    }

}

