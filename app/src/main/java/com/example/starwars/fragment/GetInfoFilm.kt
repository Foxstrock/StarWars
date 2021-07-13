package com.example.starwars.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import com.example.starwars.R
import com.example.starwars.databinding.FragmentAllFilmBinding
import com.example.starwars.databinding.FragmentGetInfoFilmBinding
import com.example.starwars.fragment.IdSingleton.url
import com.example.starwars.model.Film
import com.example.starwars.retrofit.AdapterRest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GetInfoFilm : Fragment() {

    var FilmInfo : Film = Film()

    val binding by lazy {
        FragmentGetInfoFilmBinding.inflate(layoutInflater)
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
    }

    override fun onResume() {
        super.onResume()
        getFilmInfo(url)
    }

    private fun getFilmInfo(id : String) {

        AdapterRest.clientEndPoints!!.getFilmInfo(id).enqueue(object : Callback<Film> {
            override fun onResponse(call: Call<Film>, response: Response<Film>) {

                FilmInfo = response.body()!!
                initLayout()

            }

            override fun onFailure(call: Call<Film>, t: Throwable) {
            }
        })

    }

    private fun initLayout() {
        binding.title.text = FilmInfo.title
        binding.testo.text = FilmInfo.opening_crawl
        binding.lastInfo.text = "Created : " + FilmInfo.created + "Edited : " + FilmInfo.edited
    }

}