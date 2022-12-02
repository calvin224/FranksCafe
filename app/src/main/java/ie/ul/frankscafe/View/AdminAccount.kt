package ie.ul.frankscafe.View

import android.annotation.SuppressLint
import android.app.Activity
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.AppCompatButton
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import ie.ul.frankscafe.R
import ie.ul.frankscafe.Services.CurrentUser
import ie.ul.frankscafe.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.account.*

class AdminAccount(val application: Application, val mainFragmentManager: MainFragmentManager) : Fragment(R.layout.account) {

    lateinit var binding: ActivityMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val textView: TextView = view?.findViewById(R.id.usernametxt) as TextView
        textView.setText(CurrentUser.getuser().username)

        val view: View = inflater!!.inflate(R.layout.adminaccount, container, false)

        // on switch change notification state
        notiswitch.setOnCheckedChangeListener { _, isChecked ->  //toggles notifications for current user
            // toggle.setOnCheckedChangeListener { _, isChecked ->  //toggles notifications for current user
            if (isChecked) {
                CurrentUser.getuser().isSubscribed = 1
            } else {
                CurrentUser.getuser().isSubscribed = 0
            }
        }

        //
        val dealSpinner: Spinner = view.findViewById(R.id.dealspinner)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            application,
            R.array.notioptions,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            dealSpinner.adapter = adapter
        }

        abstract class SpinnerActivity : Activity(), AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                pos: Int,
                id: Long
            ) {
                ie.ul.frankscafe.Services.NotificationManager(application).updateDeal(parent.getItemAtPosition(pos) as String)
            }

        }

        return view
    }
}