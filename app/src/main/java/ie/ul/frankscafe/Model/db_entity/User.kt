package ie.ul.frankscafe.Model.db_entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.jar.Attributes

@Entity(tableName = "Users")
data class User(
    @PrimaryKey(autoGenerate = true) val userId: Int?,
    @ColumnInfo(name = "username") val username: String?,
    @ColumnInfo(name = "password") val password: String?,
    @ColumnInfo(name = "userType") val usertype: Int?,
)