package ie.ul.frankscafe.Model.entity


class UserEntity() {
    private var userId: Int? = null
    private var username: String? = null
    private var password: String? = null
    private var userType: Int? = null
    private var isSubscribed: Int? = null


    class Builder {
        private var userId: Int? = null
        private var username: String? = null
        private var Email: String? = null
        private var password: String? = null
        private var userType: Int? = null
        private var isSubscribed: Int? = null

        fun setUsername(username: String?): Builder {
            this.username = username
            return this
        }

        fun setPassword(password: String?): Builder {
            this.password = password
            return this
        }
        fun setEmail(email: String?): Builder {
            this.Email = email
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

        fun build(): UserEntity {
            val userentity = UserEntity()
            userentity.userId = userId
            userentity.username = username
            userentity.password = password
            userentity.userType = userType
            userentity.isSubscribed = isSubscribed
            return userentity
        }

        fun getUserId(): Int? {
            return userId
        }

        fun getUserName(): String{
            return username!!
        }
        fun getEmail() : String{
            return Email!!
        }

        fun getpassword(): String{
            return password!!
        }
        fun getusertype(): Int{
            return userType!!
        }
        fun getIsSubscribed(): Int{
            return isSubscribed!!
        }

    }

}



