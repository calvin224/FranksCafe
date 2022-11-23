package ie.ul.frankscafe.Services

class CalcOrder() {
    var CurrCost = 0;
    fun calcOrder(){
        for (food in CurrentOrder.getOrders()){
            CurrCost += 1
        }
    }

    fun calcTaxes(){

    }

    fun calcDiscount(){

    }

}