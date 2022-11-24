package ie.ul.frankscafe.Model.entity

import ie.ul.frankscafe.Services.Visitable
import ie.ul.frankscafe.Services.Visitor

class MealDealA : Visitable {
    val cost = 10
    override fun accept(visitor: Visitor) : Int {
        visitor.visit(this)
        return cost
    }
    fun returnCost(): Int {
        return cost
    }
}