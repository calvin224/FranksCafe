package ie.ul.frankscafe.View

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import ie.ul.frankscafe.R
import ie.ul.frankscafe.Model.db_entity.User
import ie.ul.frankscafe.Services.CurrentUser
import ie.ul.frankscafe.ViewModel.OrderViewModel
import ie.ul.frankscafe.ViewModel.UserViewModel
import kotlinx.android.synthetic.main.register.*
import kotlinx.android.synthetic.main.signin.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.random.Random

class Signin(val application: Application)  : Fragment(R.layout.signin){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.signin, container, false)
        // set on-click listener
        val Loginbtn = view.findViewById<AppCompatButton>(R.id.Loginbtn)
        Loginbtn.setOnClickListener{

            if (UserViewModel(application).checkValidUser(loginUsername.text.toString(),loginPassword.text.toString()) == true) {
                UserViewModel(application).login(loginUsername.text.toString(),application)
                //println("User Present")
            }
            else if (UserViewModel(application).checkValidUser(loginUsername.text.toString(),loginPassword.text.toString()) == false){
//                println("User not present")
            }
        }
        return view
    }
}