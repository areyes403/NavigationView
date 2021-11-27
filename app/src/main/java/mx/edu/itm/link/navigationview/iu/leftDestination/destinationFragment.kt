package mx.edu.itm.link.navigationview.iu.leftDestination

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import mx.edu.itm.link.navigationview.R
import mx.edu.itm.link.navigationview.databinding.FragmentDestinationBinding
import mx.edu.itm.link.navigationview.iu.database.User


class destinationFragment : Fragment() {

    private  lateinit var binding:FragmentDestinationBinding
    private val destinationViewModel:DestinationViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentDestinationBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val receivedUsername=arguments?.getString("username_arg")

        binding.tvReceivedArg.setText(receivedUsername)
        binding.rvUserEntries.layoutManager=LinearLayoutManager(view.context)
        destinationViewModel.getUsers()

        destinationViewModel.savedUsers.observe(viewLifecycleOwner,{ usersList->
            if(!usersList.isNullOrEmpty()){
                val adapter=destinationAdapter(usersList)
                binding.rvUserEntries.adapter=adapter
                for(saveduser in usersList){
                    Log.d("obtainedusers","froma fragment user:")
                }
            }else{
                Log.d("obtaindesusers","fragment empty")
            }
        })
    }
}