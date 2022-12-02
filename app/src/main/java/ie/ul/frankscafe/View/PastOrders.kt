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
import ie.ul.frankscafe.Model.db_entity.PastOrder
import ie.ul.frankscafe.R
import ie.ul.frankscafe.Services.CurrentUser
import ie.ul.frankscafe.ViewModel.OrderViewModel
import ie.ul.frankscafe.ViewModel.PastOrderViewModel

class PastOrders(val application: Application, mainFragmentManager: MainFragmentManager) : Fragment(R.layout.pastorders) {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.pastorders, container, false)

        var orderList = PastOrderViewModel(application).getAllOrdersByCustomerID(CurrentUser.getuser().userId as Int)
        val arrayAdapter: ArrayAdapter<String>
        var orderListView = view?.findViewById<ListView>(R.id.PastOrders)
        arrayAdapter = ArrayAdapter(application, android.R.layout.simple_list_item_1, orderList.map { it.OrderContents + " " + it.OrderTime.substringBefore('T')} )
        orderListView?.adapter = arrayAdapter

        return view
    }

}