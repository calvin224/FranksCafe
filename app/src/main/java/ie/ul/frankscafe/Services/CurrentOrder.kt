package ie.ul.frankscafe.Services

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import ie.ul.frankscafe.Model.db.AppDatabase
import ie.ul.frankscafe.Model.db_entity.Food
import ie.ul.frankscafe.Model.db_entity.PastOrder
import ie.ul.frankscafe.Model.entity.FoodEntity
import ie.ul.frankscafe.ViewModel.PastOrderViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.util.function.Predicate
import kotlin.random.Random

//Singleton
object CurrentOrder {
    var Order: ArrayList<FoodEntity> = arrayListOf()

    val originator = Originator(FoodEntity())
    val careTaker = Caretaker()
    private var state: State? = IncompleteState()

    fun addItem(food: FoodEntity) {
        Order.add(food)
        originator.state = food
        careTaker.saveState(originator.createMemento())
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun removeItem(inFood: FoodEntity) {
        val condition: Predicate<FoodEntity> = Predicate<FoodEntity> { food -> food.getFoodName().toString() == inFood.getFoodName().toString() }
        Order.stream().filter(condition).findFirst().ifPresent(Order::remove)
    }
    fun getOrders(): ArrayList<FoodEntity> {
            return Order
    }
    fun Undo(foodlist : ArrayList<FoodEntity>){
        originator.restore(careTaker.restore(foodlist.size))
    }
    fun changeState(state: State?) {
        this.state = state
    }
    fun getState(): State? {
        return state
    }

    fun clear(){
        Order = arrayListOf()
        changeState(IncompleteState())
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun processOrder(application: Application) {
        var lastOrderID = PastOrderViewModel(application).getLastOrderID()
        var tempOrderID = 0
        if (lastOrderID != 0){
            tempOrderID = lastOrderID + 1
        } else {
            tempOrderID = 1
        }
        val ordersDao = AppDatabase.getDatabase(application).PastOrdersDao()
        var timestamp = LocalDateTime.now().toString()
        var orderContents = getOrders()
        var orderContentsList = ""
        var currentUserID = CurrentUser.getuser().userId as Int
        for (order in orderContents){
            orderContentsList = orderContentsList + (order.getFoodName()) + " "
        }

        var tempOrder = PastOrder(tempOrderID, "Completed", orderContentsList, CalcOrder().GetTotalCost(), CalcOrder().GetTotalCost(), timestamp, currentUserID)
        GlobalScope.launch(Dispatchers.IO) {
            ordersDao.addOrder(tempOrder)
        }
    }
}
