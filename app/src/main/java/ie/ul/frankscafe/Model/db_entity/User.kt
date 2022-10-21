package ie.ul.frankscafe.Model.db_entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.jar.Attributes

@Entity(tableName = "Users")
data class User(
    @PrimaryKey(autoGenerate = true) var userId: Int?,
    @ColumnInfo(name = "username") var username: String?,
    @ColumnInfo(name = "password") var password: String?,
    @ColumnInfo(name = "userType") var usertype: Int?,
)