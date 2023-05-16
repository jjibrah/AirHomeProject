package com.Abdifatah.airhome

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import java.text.FieldPosition

class MyAdapter(var homeList :ArrayList<houseDs>) :ListView.Adapter<MyAdapter.MyViewHolder> {


    override fun onCreateViewHolder(parent: ViewGroup, viewtype:Int): MyViewHolder{
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_houses,
        parent,false)
        return MyViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: MyViewHolder,position: Int){
        var currentitem = homeList[position]


        holder.mLocation.text = currentitem.houseLocation
        holder.mPrice.text = currentitem.housePrice
        holder.mDetails.text = currentitem.houseDetails
        holder.mOwner.text = currentitem.owner_email
        holder.Image.text.toString() = currentitem.houseImage
    }


    override fun getItemCount(): Int{

        return TODO("Provide the return value")
    }


      
    class MyViewHolder(itemView: View) : ListView.ViewHolder{
    var mLocation : TextView = itemView.findViewById(R.id.mEdtLocation)
    var mPrice : TextView = itemView.findViewById(R.id.mEdtPrice)
    var mDetails : TextView = itemView.findViewById(R.id.house_details)
    var mOwner : TextView = itemView.findViewById(R.id.mEdtOwnerEmail)
    var Image : ImageButton = itemView.findViewById(R.id.mAddImage)


    }
}