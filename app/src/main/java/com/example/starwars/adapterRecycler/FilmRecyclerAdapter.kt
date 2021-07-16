package com.example.starwars.adapterRecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.starwars.R
import com.example.starwars.model.Film

class FilmRecyclerAdapter(var filmList: ArrayList<Film>, val listener: View.OnClickListener?) : RecyclerView.Adapter<FilmRecyclerAdapter.RecViewHold>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecViewHold {
        return RecViewHold(LayoutInflater.from(parent.context).inflate(R.layout.filmitem, parent , false))
    }



    override fun onBindViewHolder(holder: RecViewHold, position: Int) {

        holder.name.text = filmList[position].title
        holder.episode.text = filmList[position].episode_id
        holder.date.text = filmList[position].created

        holder.itemView.setOnClickListener(listener)

    }

    override fun getItemCount(): Int {
        return filmList.size
    }

    class RecViewHold(v: View) : RecyclerView.ViewHolder(v){
        val name : TextView = v.findViewById(R.id.title)
        val episode : TextView = v.findViewById(R.id.episode)
        val date : TextView = v.findViewById(R.id.date)
    }
}