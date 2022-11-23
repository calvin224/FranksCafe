package ie.ul.frankscafe.Services

import ie.ul.frankscafe.Model.entity.MealDealA
import ie.ul.frankscafe.Model.entity.MealDealB
import ie.ul.frankscafe.Model.entity.MealDealC

interface Visitor {

    fun visit(entity: MealDealA): Int

    fun visit(entity: MealDealB): Int

    fun visit(entity: MealDealC): Int
}

