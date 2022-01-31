package com.example.qaydlar.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.qaydlar.Models.User
import com.example.qaydlar.R
import com.example.qaydlar.databinding.ItemRvBinding

class UserAdapter(val list: List<User>, val rvClick: RVClick)
    :RecyclerView.Adapter<UserAdapter.Vh>(){

    inner class Vh(var itemRv: ItemRvBinding): RecyclerView.ViewHolder(itemRv.root){
        fun onBind(user: User){
            itemRv.itemNameTv.text = list[position].name

            itemRv.cardItem.setOnClickListener {
                itemRv.root.findNavController().navigate(R.id.fragment2)
            }

            itemRv.cardItem.setOnLongClickListener {
                rvClick.deleteItem(user)
            true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    interface RVClick{
        fun deleteItem(user: User)
    }

}