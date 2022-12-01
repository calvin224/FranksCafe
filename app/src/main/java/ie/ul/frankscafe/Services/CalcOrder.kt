package ie.ul.frankscafe.Services

import ie.ul.frankscafe.Model.entity.MealDealA
import ie.ul.frankscafe.Model.entity.MealDealB
import ie.ul.frankscafe.Model.entity.MealDealC

class CalcOrder() {
    var currCost = 0.0
    var calcMealDeal = CalcMealDeal()
    val list = ArrayList<Visitable>()
    var hashMap: HashMap<String, Int> = HashMap<String, Int>()
    fun GetTotalCost(): Double {
        hashMap.put("A", 0)
        hashMap.put("B", 0)
        hashMap.put("C", 0)
        for (food in CurrentOrder.getOrders()) {
            when (food.foodType) {
                "A" -> hashMap.put("A", hashMap.getValue("A") + 1)
                "B" -> hashMap.put("B", hashMap.getValue("B") + 1)
                "C" -> hashMap.put("C", hashMap.getValue("C") + 1)
            }
            currCost += food.foodPrice
        }
        if (hashMap.getValue("A") >= 3) {
            list.add(MealDealA())
        }
        if (hashMap.getValue("B") >= 3) {
            list.add(MealDealB())
        }
        if (hashMap.getValue("C") >= 3) {
            list.add(MealDealC())
        }
        currCost = (currCost * 0.14)
        for (item in list) {
            currCost /= item.accept(calcMealDeal)
        }
        return currCost
    }
}
