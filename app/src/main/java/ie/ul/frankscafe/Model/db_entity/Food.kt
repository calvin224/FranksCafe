package ie.ul.frankscafe.Model.db_entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.jar.Attributes

@Entity(tableName = "Foods")
data class Food(
    @PrimaryKey(autoGenerate = true) var foodID: Int,
    @ColumnInfo(name = "foodName") var foodName: String,
    @ColumnInfo(name = "foodType") var foodType: String,
    @ColumnInfo(name = "mealDeal") var mealDeal: String,
    @ColumnInfo(name = "foodPrice") var foodPrice: Int,
)