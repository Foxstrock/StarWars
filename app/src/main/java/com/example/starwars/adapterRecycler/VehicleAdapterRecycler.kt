package com.example.starwars.adapterRecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.starwars.R
import com.example.starwars.model.Vehicle

class VehicleAdapterRecycler(val vehicleList: ArrayList<Vehicle>,  val listener: View.OnClickListener) : RecyclerView.Adapter<VehicleAdapterRecycler.RecViewHold>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecViewHold {
        return RecViewHold(LayoutInflater.from(parent.context).inflate(R.layout.vehicleitem, parent , false))
    }


    override fun onBindViewHolder(holder: VehicleAdapterRecycler.RecViewHold, position: Int) {

        holder.name.text = vehicleList[position].name
        holder.model.text = vehicleList[position].model
        holder.vehicleclass.text = vehicleList[position].created

        holder.itemView.setOnClickListener(listener)
    }

    override fun getItemCount(): Int {
        return vehicleList.size
    }

    class RecViewHold(v: View) : RecyclerView.ViewHolder(v){
        val name : TextView = v.findViewById(R.id.vehiclename)
        val model : TextView = v.findViewById(R.id.model)
        val vehicleclass : TextView = v.findViewById(R.id.vehicleclass)
    }
}