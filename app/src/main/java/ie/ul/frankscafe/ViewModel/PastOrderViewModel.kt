package ie.ul.frankscafe.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import ie.ul.frankscafe.Model.db.AppDatabase
import ie.ul.frankscafe.Model.db_entity.PastOrder
import ie.ul.frankscafe.repository.PastOrdersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class PastOrderViewModel(application: Application): AndroidViewModel(application) {
    val getAll : List<PastOrder>
    val repository: PastOrdersRepository

    init {
        val pastOrdersDao = AppDatabase.getDatabase(application).PastOrdersDao()
        repository = PastOrdersRepository(pastOrdersDao)
        getAll = repository.getAll
    }

    fun addOrder(order: PastOrder){
        viewModelScope.launch(Dispatchers.IO){
            repository.addOrder(order)
        }
    }

    fun GetPastOrder(id : Int){
        viewModelScope.launch(Dispatchers.IO){
            return@launch repository.GetOrder(id)
        }
    }

    fun getLastOrderID(): Int{
        return repository.getLastOrderID()
    }


    fun getAllPastOrders(): ArrayList<PastOrder>{
        return repository.getAllPastOrders()
    }

    fun getAllOrdersByCustomerID(customerID: Int): ArrayList<PastOrder>{
        return repository.getAllOrdersByCustomerID(customerID)
    }

}