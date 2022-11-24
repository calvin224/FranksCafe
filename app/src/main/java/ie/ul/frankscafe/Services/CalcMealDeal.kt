package ie.ul.frankscafe.Services

import ie.ul.frankscafe.Model.entity.MealDealA
import ie.ul.frankscafe.Model.entity.MealDealB
import ie.ul.frankscafe.Model.entity.MealDealC

class CalcMealDeal : Visitor {

    override fun visit(entity: MealDealA): Int {
            return MealDealA().returnCost()
    }

    override fun visit(entity: MealDealB): Int {
        return MealDealA().returnCost()
    }

    override fun visit(entity: MealDealC): Int {
        return MealDealA().returnCost()
    }
}