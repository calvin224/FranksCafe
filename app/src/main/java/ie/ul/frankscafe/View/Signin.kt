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

class Signin(val application: Application)  : Fragment(R.layout.signin){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.signin, container, false)
        // set on-click listener
        val regButton = view.findViewById<AppCompatButton>(R.id.Login)
        regButton.setOnClickListener{
                val fm = (activity as FragmentActivity).supportFragmentManager
                val fragmentTransaction = fm.beginTransaction()
                fragmentTransaction.replace(R.id.fragment_container, Fragment(R.layout.signin))
                fragmentTransaction.commit()
            val user = User(9922, "calvin2322", "franom2", "123", 1, 1)
            login(user)
        }
        return view
    }

    fun login(user: User){
        UserViewModel(application).login(user,application)
    }

}