package ie.ul.frankscafe.View

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import ie.ul.frankscafe.Model.db_entity.User
import ie.ul.frankscafe.R
import ie.ul.frankscafe.ViewModel.UserViewModel
import ie.ul.frankscafe.databinding.ActivityMainBinding

public class Register (val application: Application) : Fragment(R.layout.register) {
    val user = User(9914,"calvin2332","123","pass", 1, 1)
    lateinit var binding: ActivityMainBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.register, container, false)
        val registerButton = view.findViewById<AppCompatButton>(R.id.registerButton)
        // set on-click listener
        registerButton.setOnClickListener{
            UserViewModel(application).addUser(user)
            print("test")
        }
        return view
    }
}



