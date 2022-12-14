package ie.ul.frankscafe.Model.db_entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.jar.Attributes

@Entity(tableName = "PastOrders")
data class PastOrder(
    @PrimaryKey(autoGenerate = true) var orderID: Int,
    @ColumnInfo(name = "OrderStatus") var OrderStatus: String,
    @ColumnInfo(name = "OrderContents") var OrderContents: String,
    @ColumnInfo(name = "PaidAmount") var OrderAmount: Double,
    @ColumnInfo(name = "OrderCost") var OrderCost: Double,
    @ColumnInfo(name = "OrderTime") var OrderTime: String,
    @ColumnInfo(name = "CustomerID") var CustomerID: Int,

)