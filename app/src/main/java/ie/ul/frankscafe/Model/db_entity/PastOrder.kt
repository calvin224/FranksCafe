package ie.ul.frankscafe.Model.db_entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.jar.Attributes

@Entity(tableName = "PastOrders")
data class PastOrder(
    @PrimaryKey(autoGenerate = true) var orderID: Int,
    @ColumnInfo(name = "OrderStatus") var OrderStatus: String,
    @ColumnInfo(name = "OrderCost") var OrderCost: String
)