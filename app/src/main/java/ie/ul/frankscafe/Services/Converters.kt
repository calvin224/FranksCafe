package ie.ul.frankscafe.Services

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun toNotificationPreference(value: Int): NotificationStrategy? {
        var notificationPreference: NotificationStrategy = PushNotification()
        when (value) {
            1 -> notificationPreference = EmailNotification()

            2 -> notificationPreference = PushNotification()

            3 -> notificationPreference = NoPreference()
        }
        return notificationPreference
    }

    @TypeConverter
    fun fromNotificationPreference(value: NotificationStrategy?): Int {
        var notificationPreference = 0
        when (value) {
            EmailNotification() -> notificationPreference = 1

            PushNotification() -> notificationPreference = 2

            NoPreference() -> notificationPreference = 3
        }
        return notificationPreference
    }
}