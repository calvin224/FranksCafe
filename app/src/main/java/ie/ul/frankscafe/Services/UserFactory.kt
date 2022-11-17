package ie.ul.frankscafe.Services

import ie.ul.frankscafe.Model.db_entity.User

class UserFactory(user: User) {

    fun IsAdminFactory(user: User): String {
        if(user.usertype == 0){
            return "User"
        } else {
            return "Admin"
        }
    }
}