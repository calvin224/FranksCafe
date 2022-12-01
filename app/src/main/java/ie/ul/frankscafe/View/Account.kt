package ie.ul.frankscafe.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import ie.ul.frankscafe.R

class Account : Fragment(R.layout.account){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.account, container, false)
        val regButton = view.findViewById<AppCompatButton>(R.id.pastorders)
        regButton.setOnClickListener{

            val fm = (activity as FragmentActivity).supportFragmentManager
            val fragmentTransaction = fm.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, Fragment(R.layout.pastorders))
            fragmentTransaction.commit()

        }
        return view
    }

}