package com.example.android.navigation


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {

    //Similar to onCreate on MainActivity
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater, R.layout.fragment_title,container,false)
        binding.playButton.setOnClickListener{
            view : View -> view.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
        }
        setHasOptionsMenu(true)
        return binding.root     //Return inflate output
    }

    /*
    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        //!! = Prevents null pointer exception on Kotlin
        return NavigationUI.onNavDestinationSelected(item!!,
                view!!.findNavController() || super.onOptionsItemSelected(item))
    }

     */

}
