package com.dreamhome.fragment

import android.content.AbstractThreadedSyncAdapter
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dreamhome.R
import com.dreamhome.adapter.HomeRv1
import com.dreamhome.adapter.HomeRv2
import com.dreamhome.adapter.HomeRv3


class DashBoard : Fragment() {
    lateinit var recyclerDashboard: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager

    lateinit var recyclerDashboard2: RecyclerView
    lateinit var layoutManager2: RecyclerView.LayoutManager

    lateinit var recyclerDashboard3: RecyclerView
    lateinit var layoutManager3: RecyclerView.LayoutManager

    val homeList= arrayListOf(R.drawable.home1,R.drawable.image2,R.drawable.image3,R.drawable.image4)
    val homeList2=arrayListOf(R.drawable.inner1,R.drawable.inner2,R.drawable.inner3,R.drawable.inner4,R.drawable.inner5)
    val homeList3=arrayListOf(R.drawable.fur1,R.drawable.fur2,R.drawable.fur3)
    lateinit var homeRv1Adapter: HomeRv1
    lateinit var homeRv2Adapter: HomeRv2
    lateinit var homeRv3Adapter: HomeRv3
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      val view= inflater.inflate(R.layout.fragment_dash_board, container, false)
        recyclerDashboard= view.findViewById(R.id.dashrecycler)
        recyclerDashboard2= view.findViewById(R.id.dashrecycler1)
        recyclerDashboard3= view.findViewById(R.id.dashrecycler2)


        layoutManager= LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,true)
        layoutManager2= LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,true)
        layoutManager3= LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,true)


        homeRv1Adapter= HomeRv1(activity as Context, homeList)
        homeRv2Adapter=HomeRv2(activity as Context, homeList2)
        homeRv3Adapter=HomeRv3(activity as Context, homeList3)

        recyclerDashboard.adapter=homeRv1Adapter
        recyclerDashboard.layoutManager=layoutManager

        recyclerDashboard2.adapter=homeRv2Adapter
        recyclerDashboard2.layoutManager=layoutManager2

        recyclerDashboard3.adapter=homeRv3Adapter
        recyclerDashboard3.layoutManager=layoutManager3

        return view
    }


}
