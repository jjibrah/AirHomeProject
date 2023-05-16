package com.Abdifatah.airhome

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class HomeAdapter(var context: Context, var data:ArrayList<Home>):BaseAdapter() {
    private class ViewHolder(row:View?){
        var mHouse : ImageView
        var mLocation : TextView
        var mPrice : TextView
        init {
            this.mHouse = row?.findViewById(R.id.mHouse) as ImageView
            this.mLocation = row.findViewById(R.id.mTvLocation) as TextView
            this.mPrice = row.findViewById(R.id.mPrice) as TextView
        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view:View?
        var viewHolder:ViewHolder
        if (convertView == null){
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.viewholder_houses,parent,false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var home:Home = getItem(position) as Home
        Glide.with(context).load(home.image).into(viewHolder.mHouse);
        viewHolder.mLocation.text = home.location
        viewHolder.mPrice.text = home.price

        return view as View
    }

    override fun getItem(position: Int): Any {
        return  data.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.count()
    }
}

