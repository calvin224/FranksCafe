package ie.ul.frankscafe.Services

import android.app.Application
import ie.ul.frankscafe.repository.UserRepository

class NotificationManager(application: Application) {

    val repository = UserRepository(application)

    fun updateDeal(dailyDeal: String){
        var dailyDeal = dailyDeal
        repository.notifyAllSubscribed(dailyDeal)
    }
}