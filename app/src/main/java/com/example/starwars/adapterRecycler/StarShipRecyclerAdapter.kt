package com.example.starwars.adapterRecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.starwars.R
import com.example.starwars.model.Starship

class StarShipRecyclerAdapter(var starShipList : ArrayList<Starship> , var listener : View.OnClickListener) : RecyclerView.Adapter<StarShipRecyclerAdapter.RecViewHold>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecViewHold {
        return RecViewHold(LayoutInflater.from(parent.context).inflate(R.layout.starshipitem, parent , false))
    }


    override fun onBindViewHolder(holder: StarShipRecyclerAdapter.RecViewHold, position: Int) {

        holder.name.text = starShipList[position].name
        holder.model.text = starShipList[position].model
        holder.starClass.text = starShipList[position].created

        holder.itemView.setOnClickListener(listener)
    }

    override fun getItemCount(): Int {
        return starShipList.size
    }

    class RecViewHold(v: View) : RecyclerView.ViewHolder(v){
        val name : TextView = v.findViewById(R.id.name)
        val model : TextView = v.findViewById(R.id.model)
        val starClass : TextView = v.findViewById(R.id.starClass)
    }
}