package mx.edu.itm.link.navigationview.iu.leftDestination

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import mx.edu.itm.link.navigationview.databinding.ItemUserBinding
import mx.edu.itm.link.navigationview.iu.database.User

class destinationAdapter(private val users:List<User>) :RecyclerView.Adapter<destinationAdapter.DestinationHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DestinationHolder {
        val binding=ItemUserBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DestinationHolder(binding)
    }

    override fun onBindViewHolder(holder: destinationAdapter.DestinationHolder, position: Int) {
        holder.render(users[position])
    }

    override fun getItemCount(): Int = users.size

    class DestinationHolder(val binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root){
        fun render(user:User){

            binding.tvUserNumber.setText(user.id)
            binding.tvUserName.setText(user.username)

        }
    }


}