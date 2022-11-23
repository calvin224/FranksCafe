package ie.ul.frankscafe.Model.entity

import ie.ul.frankscafe.Services.Visitable
import ie.ul.frankscafe.Services.Visitor

class MealDealC : Visitable {
    val cost = 20
    override fun accept(visitor: Visitor): Int {
        visitor.visit(this)
        return cost
    }

    fun returnCost(): Int {
        return cost
    }
}