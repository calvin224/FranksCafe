package ie.ul.frankscafe.View

import android.annotation.SuppressLint
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
import ie.ul.frankscafe.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.account.*

class AdminAccount(val application: Application, val mainFragmentManager: MainFragmentManager) : Fragment(R.layout.account) {

    lateinit var binding: ActivityMainBinding

    val textView: TextView = findViewById(R.id.usernametxt) as TextView
    textView.text = getString(CurrentUser.getuser().username)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater!!.inflate(R.layout.account, container, false)
        val toggle = view.findViewById<Switch>(R.id.notiswitch)
        //val user = CurrentUser.getuser()

        // on switch change notification state
        notiswitch.setOnCheckedChangeListener { _, isChecked ->  //toggles notifications for current user
            // toggle.setOnCheckedChangeListener { _, isChecked ->  //toggles notifications for current user
            if (isChecked) {
                user.setUserSubscribedStatus(1)
            } else {
                user.setUserSubscribedStatus(0)
            }
        }

        //
        val spinner: Spinner = view.findViewById(R.id.dealspinner)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            application,
            R.array.notioptions,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

        class SpinnerActivity : Activity(), AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                pos: Int,
                id: Long
            ) {
                // An item was selected. You can retrieve the selected item using
                // parent.getItemAtPosition(pos)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Another interface callback
            }
        }

        val spinner: Spinner = findViewById(R.id.dealspinner)
        spinner.onItemSelectedListener = this

        return view
    }
}