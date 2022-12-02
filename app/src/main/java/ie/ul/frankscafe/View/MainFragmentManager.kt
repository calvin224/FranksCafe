package ie.ul.frankscafe.View

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import ie.ul.frankscafe.R

class MainFragmentManager(fragmentManager: FragmentManager, fragmentContainer: Int) {
    private val mainFragmentManager = fragmentManager
    private val mainFragmentContainer = fragmentContainer
    fun replaceFragment(fragment : Fragment){
        val fragmentTransaction = mainFragmentManager.beginTransaction()
        fragmentTransaction.replace(mainFragmentContainer, fragment)
        fragmentTransaction.commit()
    }

}