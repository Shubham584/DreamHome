package com.dreamhome.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.dreamhome.R

class HomeRv1(val context: Context, val itemList: ArrayList<Int>) :
    RecyclerView.Adapter<HomeRv1.HomeRv1ViewHolder>() {
    class HomeRv1ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img: ImageView = view.findViewById(R.id.imgview)
    }

    override fun onBindViewHolder(holder: HomeRv1ViewHolder, position: Int) {

        holder.img.setImageResource(itemList[position])


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRv1ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.singleitem, parent, false)
        return HomeRv1ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return itemList.size

    }
}