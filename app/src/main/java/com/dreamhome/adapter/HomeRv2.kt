package com.dreamhome.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.dreamhome.R

class HomeRv2(val context: Context, val itemList: ArrayList<Int>) : RecyclerView.Adapter<HomeRv2.HomeRv2ViewHolder>()  {
    class HomeRv2ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img: ImageView = view.findViewById(R.id.imgview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRv2ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.singleitem, parent, false)
        return HomeRv2.HomeRv2ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: HomeRv2ViewHolder, position: Int) {
        holder.img.setImageResource(itemList[position])
    }
}