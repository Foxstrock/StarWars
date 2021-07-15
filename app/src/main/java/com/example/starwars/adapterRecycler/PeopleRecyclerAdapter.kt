package com.example.starwars.adapterRecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.starwars.R
import com.example.starwars.model.People

class PeopleRecyclerAdapter(var peopleList: ArrayList<People>, val listener: View.OnClickListener?) : RecyclerView.Adapter<PeopleRecyclerAdapter.RecViewHold>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecViewHold {
            return RecViewHold(LayoutInflater.from(parent.context).inflate(R.layout.peopleitem, parent , false))
        }



        override fun onBindViewHolder(holder: RecViewHold, position: Int) {

            holder.name.text = peopleList[position].name
            holder.birth.text = peopleList[position].created
            holder.gender.text = peopleList[position].gender

            holder.itemView.setOnClickListener(listener)

        }

        override fun getItemCount(): Int {
            return peopleList.size
        }

        class RecViewHold(v: View) : RecyclerView.ViewHolder(v){
            val name : TextView = v.findViewById(R.id.name)
            val gender: TextView = v.findViewById(R.id.gender)
            val birth : TextView = v.findViewById(R.id.birth_year)
        }
    }
