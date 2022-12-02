package ie.ul.frankscafe.repository

import ie.ul.frankscafe.Model.Dao.PastOrdersDao
import ie.ul.frankscafe.Model.db_entity.PastOrder

class PastOrdersRepository(private val pastOrdersDao: PastOrdersDao) {
    val getAll: List<PastOrder> = pastOrdersDao.getAll()

    suspend fun addOrder(pastOrder: PastOrder){
        pastOrdersDao.addOrder(pastOrder)
    }
    suspend fun GetOrder(id : Int){
        pastOrdersDao.getOrder(id)
    }

}