package ie.ul.frankscafe.Model.entity

import ie.ul.frankscafe.Services.NotificationStrategy


class UserEntity() {
    private var userId: Int? = null
    private var username: String? = null
    private var email: String? = null
    private var password: String? = null
    private var userType: Int? = null
    private var isSubscribed: Int? = null
    private var userNotificationPreference: NotificationStrategy? = null


    class Builder {
        private var userId: Int? = null
        private var username: String? = null
        private var email: String? = null
        private var password: String? = null
        private var userType: Int? = null
        private var isSubscribed: Int? = null
        private var userNotificationPreference: NotificationStrategy? = null

        fun setUsername(username: String?): Builder {
            this.username = username
            return this
        }

        fun setPassword(password: String?): Builder {
            this.password = password
            return this
        }
        fun setEmail(email: String?): Builder {
            this.email = email
            return this
        }

        fun setUserId(userid: Int?): Builder {
            this.userId = userid
            return this
        }

        fun setUserType(usertype: Int?): Builder {
            this.userType = usertype
            return this
        }

        fun setUserSubscribedStatus(isSubscribed: Int?): Builder {
            this.isSubscribed = isSubscribed
            return this
        }

        fun getUserID(): Int?{
            return userId
        }

        fun getUsername(): String?{
            return username
        }

        fun getUserEmail(): String?{
            return email
        }

        fun getUserType(): Int?{
            return userType
        }

        fun getUserSubscribed(): Int?{
            return isSubscribed
        }

        fun getUserNotificationPreference(): NotificationStrategy?{
            return userNotificationPreference
        }

        fun build(): UserEntity {
            val userentity = UserEntity()
            userentity.userId = userId
            userentity.username = username
            userentity.password = password
            userentity.userType = userType
            userentity.isSubscribed = isSubscribed
            return userentity
        }
    }
}



