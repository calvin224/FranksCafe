package ie.ul.frankscafe.repository

import android.app.Application

class NotificationManager(application: Application) {
    val repository = UserRepository(application)

    fun updateDeal(dailyDeal: String){
        var dailyDeal = dailyDeal
        repository.notifyAllSubscribed(dailyDeal)
    }
}