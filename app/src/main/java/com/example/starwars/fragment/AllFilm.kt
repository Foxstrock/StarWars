package com.example.starwars.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.starwars.R
import com.example.starwars.adapterRecycler.FilmRecyclerAdapter
import com.example.starwars.databinding.FragmentAllFilmBinding
import com.example.starwars.model.Film
import com.example.starwars.model.FilmList
import com.example.starwars.retrofit.AdapterRest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AllFilm : Fragment(),View.OnClickListener {

   private var filmList : ArrayList<Film> = ArrayList()

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

        binding.listafilm.setOnClickListener(this)
        getAllFilms()
    }

    fun getAllFilms(){
        AdapterRest.clientEndPoints!!.getAllFilms().enqueue(object : Callback<FilmList>{
            override fun onResponse(call: Call<FilmList>, response: Response<FilmList>) {


                    filmList.addAll(response.body()!!.results)
                    initRecycler()



            }

            override fun onFailure(call: Call<FilmList>, t: Throwable) {
            }
        })
    }

    fun initRecycler() {
        binding.listafilm.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.listafilm.adapter = FilmRecyclerAdapter(filmList , this::onClick)
    }

    override fun onClick(v: View?) {
        var url : String = filmList[binding.listafilm.getChildLayoutPosition(v!!)].url
        url = url.drop(28)
        url = url.dropLast(1)
        IdSingleton.url = url
        findNavController().navigate(R.id.action_allFilm_to_getInfoFilm)
    }


}