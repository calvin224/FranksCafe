package ie.ul.frankscafe.repository

import ie.ul.frankscafe.Model.Dao.PastOrdersDao
import ie.ul.frankscafe.Model.db_entity.PastOrder
import ie.ul.frankscafe.View.PastOrders

class PastOrdersRepository(private val pastOrdersDao: PastOrdersDao) {
    val getAll: List<PastOrder> = pastOrdersDao.getAll()

    suspend fun addOrder(pastOrder: PastOrder){
        pastOrdersDao.addOrder(pastOrder)
    }

    fun getAllPastOrders(): ArrayList<PastOrder>{
        var getAllFoods = ArrayList(getAll)
        return getAllFoods
    }

    suspend fun GetOrder(id : Int){
        pastOrdersDao.getOrder(id)
    }

    fun getLastOrderID(): Int{
        return pastOrdersDao.getLastOrderID()
    }

    fun getAllOrdersByCustomerID(customerID: Int): ArrayList<PastOrder>{
        var getAllOrdersByID = ArrayList(pastOrdersDao.getAllOrdersByCustomerID(customerID))
        return getAllOrdersByID
    }

}