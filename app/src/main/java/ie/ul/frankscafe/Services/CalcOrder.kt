package ie.ul.frankscafe.Services

import ie.ul.frankscafe.Model.entity.MealDealA
import ie.ul.frankscafe.Model.entity.MealDealB
import org.checkerframework.checker.units.qual.C

class CalcOrder() {
    var currCost = 0;
    var calcMealDeal = CalcMealDeal()
    val list = ArrayList<Visitable>()
    val discounts = ArrayList<Int>()
    fun calcOrder() {
        for (food in CurrentOrder.getOrders()) {
            //when done a meal deal create meal deal entity then add to list
            //MealDealA = foodsitems
        }
        for(item in list){
            val temp = item.accept(calcMealDeal)
           discounts.add(temp)
        }
    }

    fun calcTaxes(){

    }

    fun calcDiscount(){


    }

}