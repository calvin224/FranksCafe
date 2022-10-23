package ie.ul.frankscafe

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import ie.ul.frankscafe.Model.db.AppDatabase
import ie.ul.frankscafe.Model.db_entity.Food
import ie.ul.frankscafe.Model.entity.FoodEntity
import ie.ul.frankscafe.ViewModel.FoodViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ReadAllFood()

 }

    fun ReadAllFood(){
        GlobalScope.launch(Dispatchers.IO) {
            val textView : TextView = findViewById(R.id.textView) as TextView
            textView.setText((FoodViewModel(application).getAll.get(0).foodName) + " " + (FoodViewModel(application).getAll.get(1).foodName))
        }
    }
}


