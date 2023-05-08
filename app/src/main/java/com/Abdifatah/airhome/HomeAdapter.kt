package com.Abdifatah.airhome

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomeAdapter (var homelist:ArrayList<Homes>)
    :RecyclerView.Adapter<HomeAdapter.HomeViewHolder>(){

    var onItemClick : ((Homes) -> Unit)? = null

    class HomeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var mHouse : ImageView = itemView.findViewById(R.id.mHouse)
        var mLocation : TextView = itemView.findViewById(R.id.mTvLocation)
        var mPrice : TextView = itemView.findViewById(R.id.mPrice)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_houses, parent, false)
        return HomeViewHolder(view)
    }

    override fun getItemCount():Int {
        return homelist.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int){
        var home = homelist[position]
        holder.mHouse.setImageResource(home.image)
        holder.mLocation.text = home.location
        holder.mPrice.text = home.price

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(home)
        }
    }

}

