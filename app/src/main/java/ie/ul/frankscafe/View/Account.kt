package ie.ul.frankscafe.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.ToggleButton
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import ie.ul.frankscafe.Model.entity.UserEntity
import ie.ul.frankscafe.R
import ie.ul.frankscafe.Services.CurrentUser
import ie.ul.frankscafe.ViewModel.UserViewModel
import ie.ul.frankscafe.databinding.ActivityMainBinding

class Account : Fragment(R.layout.account){


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.account, container, false)
        val regButton = view.findViewById<AppCompatButton>(R.id.pastorders)
        val toggle = view.findViewById<Switch>(R.id.notificationToggle)
        val user = CurrentUser.getuser()

        regButton.setOnClickListener{

            val fm = (activity as FragmentActivity).supportFragmentManager
            val fragmentTransaction = fm.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, Fragment(R.layout.pastorders))
            fragmentTransaction.commit()

        }

        toggle.setOnCheckedChangeListener { _, isChecked ->  //toggles notifications for current user
            if (isChecked) {
                user.setUserSubscribedStatus(1)
            } else {
                user.setUserSubscribedStatus(0)
            }
        }

        return view
    }

}