package ie.ul.frankscafe.Services

import ie.ul.frankscafe.Model.db_entity.Food

//Singleton
object CurrentOrder {
    var Order: ArrayList<Food> = emptyList<Food>() as ArrayList<Food>
    val originator = Originator(Food(0,"initial state","","",1.0))
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
}
