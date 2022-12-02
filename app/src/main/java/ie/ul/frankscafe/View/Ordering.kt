package ie.ul.frankscafe.View

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import ie.ul.frankscafe.Model.entity.FoodEntity
import ie.ul.frankscafe.R
import ie.ul.frankscafe.ViewModel.OrderViewModel
import org.w3c.dom.Element

class Ordering(val application: Application, val mainFragmentManager: MainFragmentManager) : Fragment(R.layout.ordering) {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.ordering, container, false)

        var italianFoodsList = view.findViewById<ListView>(R.id.Italian)
        var mexicanFoodsList = view.findViewById<ListView>(R.id.Mexican)
        var chineseFoodsList = view.findViewById<ListView>(R.id.Chinese)

        var placeOrderBtn = view.findViewById<AppCompatButton>(R.id.Order)

        placeOrderBtn.setOnClickListener{
            OrderViewModel(application).processOrder(application)
            mainFragmentManager.replaceFragment(PastOrders(application, mainFragmentManager))
        }

        populateFoodListView(italianFoodsList, "A")
        populateFoodListView(mexicanFoodsList, "B")
        populateFoodListView(chineseFoodsList, "C")

        return view
    }

    fun populateFoodListView(listView: ListView, mealDeal: String){
        var foodList = OrderViewModel(application).getAllFoodsByMealDeal(mealDeal)
        val arrayAdapter: ArrayAdapter<String>
        var foodListView = listView
        arrayAdapter = ArrayAdapter(application, android.R.layout.simple_list_item_1, foodList.map { it.getFoodName() + " " + "€" + it.getFoodPrice()} )
        foodListView.adapter = arrayAdapter

        listView.setOnItemClickListener { parent, view, position, id ->
            val elementClicked = listView.getItemAtPosition(position) as String
            var foodName = (elementClicked.substringBefore('€')).dropLast(1)

            OrderViewModel(application).addItem(OrderViewModel(application).getFoodByName(foodName))
            populateOrderListView()
        }
    }

    fun populateOrderListView(){
        var foodList = OrderViewModel(application).getOrder()
        val arrayAdapter: ArrayAdapter<String>
        var orderListView = view?.findViewById<ListView>(R.id.YourOrder)
        arrayAdapter = ArrayAdapter(application, android.R.layout.simple_list_item_1, foodList.map { it.getFoodName() + " " + "€" + it.getFoodPrice()} )
        orderListView?.adapter = arrayAdapter

        orderListView?.setOnItemClickListener { parent, view, position, id ->
            val elementClicked = orderListView.getItemAtPosition(position) as String
            var foodName = (elementClicked.substringBefore('€')).dropLast(1)

            OrderViewModel(application).removeItem(OrderViewModel(application).getFoodByName(foodName))
            populateOrderListView()
        }
    }

}