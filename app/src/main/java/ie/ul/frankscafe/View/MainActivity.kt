package ie.ul.frankscafe.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.room.Index.Order
import ie.ul.frankscafe.R
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


        binding.fragment1btn.setOnClickListener {

            replaceFragment(Signin())

        }

        binding.fragment2btn.setOnClickListener {

            replaceFragment(Register())

        }

        binding.fragment3btn.setOnClickListener {

           replaceFragment(Account())

       }

        binding.fragment4btn.setOnClickListener {

           replaceFragment(Home())

       }

        binding.fragment5btn.setOnClickListener {

            replaceFragment(Ordering())

        }

        binding.fragment6btn.setOnClickListener {

            replaceFragment(PastOrders())

        }
 }
    private fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }
}


