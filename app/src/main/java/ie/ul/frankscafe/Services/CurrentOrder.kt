package ie.ul.frankscafe.Services

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import ie.ul.frankscafe.Model.db.AppDatabase
import ie.ul.frankscafe.Model.db_entity.Food
import ie.ul.frankscafe.Model.db_entity.PastOrder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.time.LocalDateTime

//Singleton
object CurrentOrder {
    var Order: ArrayList<Food> = emptyList<Food>() as ArrayList<Food>
    val originator = Originator(Food(0,"initial state","","",1))
    val careTaker = Caretaker()
    private var state: State? = null

    fun addItem(food: Food) {
        Order.add(food)
        originator.state = food
        careTaker.saveState(originator.createMemento())
    }
    fun removeItem(food: Food) {
        Order.remove(food)
    }
    fun getOrders(): ArrayList<Food> {
            return Order
    }
    fun Undo(foodlist : ArrayList<Food>){
        originator.restore(careTaker.restore(foodlist.size))
    }
    fun changeState(state: State?) {
        this.state = state
    }
    fun getState(): State? {
        return state
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun processOrder(application: Application) {
        val ordersDao = AppDatabase.getDatabase(application).PastOrdersDao()
        var timestamp = LocalDateTime.now().toString()
        var orderContents = getOrders()
        var orderContentsList = ""

        for (order in orderContents){
            orderContentsList = orderContentsList + (order.foodID) + " "
        }

        var tempOrder = PastOrder(1, "Completed", orderContentsList, CalcOrder().GetTotalCost(), CalcOrder().GetTotalCost(), timestamp)
        GlobalScope.launch(Dispatchers.IO) {
            ordersDao.addOrder(tempOrder)
        }
    }
}
