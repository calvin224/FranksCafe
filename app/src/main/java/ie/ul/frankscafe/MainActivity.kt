package ie.ul.frankscafe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import ie.ul.frankscafe.ViewModel.FoodViewModel
import ie.ul.frankscafe.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ReadAllFood()

        binding.fragment1btn.setOnClickListener {

            replaceFragment(Signin())

        }

        binding.fragment2btn.setOnClickListener {

            replaceFragment(Register())

        }
 }
    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }

    fun ReadAllFood(){
        GlobalScope.launch(Dispatchers.IO) {
            val textView : TextView = findViewById(R.id.textView) as TextView
            textView.setText((FoodViewModel(application).getAll.get(0).foodName) + " " + (FoodViewModel(application).getAll.get(1).foodName))
        }
    }
}


