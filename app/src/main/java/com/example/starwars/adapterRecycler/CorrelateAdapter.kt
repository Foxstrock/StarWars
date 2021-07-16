package com.example.starwars.adapterRecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.starwars.R
import com.example.starwars.model.Film

class CorrelateAdapter(val correlate: ArrayList<String>, val listener: View.OnClickListener?) : RecyclerView.Adapter<CorrelateAdapter.RecViewHold>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecViewHold {
        return RecViewHold(LayoutInflater.from(parent.context).inflate(R.layout.correlateitem, parent , false))
    }


    override fun onBindViewHolder(holder: CorrelateAdapter.RecViewHold, position: Int) {

        holder.corr.text = correlate[position]

        holder.itemView.setOnClickListener(listener)
    }

    override fun getItemCount(): Int {
        return correlate.size
    }

    class RecViewHold(v: View) : RecyclerView.ViewHolder(v){
        val corr : TextView = v.findViewById(R.id.correlate)
    }
}