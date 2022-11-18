package ie.ul.frankscafe.View

import android.app.Application
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ie.ul.frankscafe.Model.db_entity.User
import ie.ul.frankscafe.R
import ie.ul.frankscafe.ViewModel.UserViewModel
import ie.ul.frankscafe.databinding.ActivityMainBinding

public class Register (application : Application) : Fragment(R.layout.register) {
    var appCompatActivity = AppCompatActivity()
    var application = application
    val user = User(99,"calvin23","123","pass", 1, 1)
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // get reference to button
        val registerButton = appCompatActivity.findViewById(R.id.registerButton) as androidx.appcompat.widget.AppCompatButton

        // set on-click listener
        registerButton.setOnClickListener {
            UserViewModel(application).addUser(user)
        }
    }

}