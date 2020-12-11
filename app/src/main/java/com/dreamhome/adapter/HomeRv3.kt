package com.dreamhome.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.dreamhome.R

class HomeRv3 (val context: Context, val itemList: ArrayList<Int>)  : RecyclerView.Adapter<HomeRv3.HomeRv3ViewHolder>()  {
    class HomeRv3ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img: ImageView = view.findViewById(R.id.imgview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRv3ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.singleitem, parent, false)
        return HomeRv3.HomeRv3ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: HomeRv3ViewHolder, position: Int) {
        holder.img.setImageResource(itemList[position])
    }
}