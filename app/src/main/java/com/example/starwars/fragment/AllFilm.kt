package com.example.starwars.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.starwars.databinding.FragmentAllFilmBinding
import com.example.starwars.model.Film
import com.example.starwars.model.FilmList
import com.example.starwars.retrofit.AdapterRest
import com.example.starwars.retrofit.RecyclerAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AllFilm : Fragment() {

   private val filmList : ArrayList<Film> = ArrayList()

    val binding by lazy {
        FragmentAllFilmBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getAllFilms()
    }

    fun getAllFilms(){
        AdapterRest.clientEndPoints?.getAllFilms()?.enqueue(object : Callback<FilmList>{
            override fun onResponse(call: Call<FilmList>, response: Response<FilmList>) {
                if(response.body() != null) {
                    filmList.clear()
                    filmList.addAll(response.body()!!.result)
                    initRecycler()
                }


            }

            override fun onFailure(call: Call<FilmList>, t: Throwable) {
            }
        })
    }

    fun initRecycler() {
        binding.listafilm.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.listafilm.adapter = RecyclerAdapter(filmList)
    }


}