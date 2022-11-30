package ie.ul.frankscafe.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.FragmentManager
import ie.ul.frankscafe.R
import kotlinx.android.synthetic.main.signin.*
import com.google.android.material.R.id.container
import ie.ul.frankscafe.ViewModel.UserViewModel

class Signin : Fragment(R.layout.signin) {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.signin, container, false)
        // set on-click listener
        val regButton = view.findViewById<AppCompatButton>(R.id.regButton)
        regButton.setOnClickListener{

                val fm = (activity as FragmentActivity).supportFragmentManager
                val fragmentTransaction = fm.beginTransaction()
                fragmentTransaction.replace(R.id.fragment_container, Fragment(R.layout.register))
                fragmentTransaction.commit()

        }
        return view
    }


}