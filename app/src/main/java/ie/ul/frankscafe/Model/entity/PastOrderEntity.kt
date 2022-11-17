package ie.ul.frankscafe.Model.entity

class PastOrderEntity{
    private var orderID: Int? = null
    private var OrderStatus: String? = null
    private var orderCost: String? = null


    //BUILDER PATTERN
    class Builder {
        private var orderID: Int? = null
        private var OrderStatus: String? = null
        private var orderCost: String? = null

        fun setorderID(orderID: Int?): Builder {
            this.orderID = orderID
            return this
        }

        fun setOrderStatus(OrderStatus: String?): Builder {
            this.OrderStatus = OrderStatus
            return this
        }

        fun setorderCost(orderCost: String?): Builder {
            this.orderCost = orderCost
            return this
        }

        fun build(): PastOrderEntity {
            val pastOrderEntity = PastOrderEntity()
            pastOrderEntity.orderID = orderID
            pastOrderEntity.OrderStatus = OrderStatus
            pastOrderEntity.orderCost = orderCost
            return pastOrderEntity
        }
    }
}
