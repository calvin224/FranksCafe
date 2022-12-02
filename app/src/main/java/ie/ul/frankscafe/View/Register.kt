package ie.ul.frankscafe.View

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import ie.ul.frankscafe.Model.db_entity.User
import ie.ul.frankscafe.R
import ie.ul.frankscafe.ViewModel.UserViewModel
import ie.ul.frankscafe.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.register.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.random.Random

public class Register (val application: Application) : Fragment(R.layout.register) {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.register, container, false)
        val registerButton = view.findViewById<AppCompatButton>(R.id.registerButton)

        // set on-click listener
        registerButton.setOnClickListener{
            val user = User( Random.nextInt(0, 9999999),registerUsername.text.toString(),registerEmail.text.toString(),registerPassword.text.toString(), 1, 1)
            addUser(user)
        }
        return view
    }

    fun addUser(user: User) {
        GlobalScope.launch(Dispatchers.IO) {
            UserViewModel(application).register(user)
        }
    }
}



