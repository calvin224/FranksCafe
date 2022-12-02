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
import ie.ul.frankscafe.Services.EmailNotification
import ie.ul.frankscafe.Services.NoPreference
import ie.ul.frankscafe.Services.PushNotification
import ie.ul.frankscafe.ViewModel.UserViewModel
import ie.ul.frankscafe.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.register.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.random.Random

class Register (val application: Application, val mainFragmentManager: MainFragmentManager) : Fragment(R.layout.register) {
    val user = User(9914,"calvin2332","123","pass", 1, 1, 1)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.register, container, false)
        val registerButton = view.findViewById<AppCompatButton>(R.id.registerButton)
        var randomIDGenerator = Random(System.currentTimeMillis())
        var randomUserID = randomIDGenerator.nextInt(0, 9999999)

        // set on-click listener
        registerButton.setOnClickListener{
            val user = User(randomUserID, registerUsername.text.toString(), registerEmail.text.toString(), registerPassword.text.toString(), 0, 1, 2)
            addUser(user)
            mainFragmentManager.replaceFragment(Signin(application, mainFragmentManager))
        }
        return view
    }

    fun addUser(user: User) {
        GlobalScope.launch(Dispatchers.IO) {
            UserViewModel(application).register(user)
        }
    }
}



