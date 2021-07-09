package com.example.starwars.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.starwars.R
import com.example.starwars.databinding.FragmentAllFilmBinding
import com.example.starwars.model.People
import com.example.starwars.model.PeopleList
import com.example.starwars.retrofit.AdapterRest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AllPeople : Fragment() {

    val binding by lazy {
        FragmentAllFilmBinding.inflate(layoutInflater)
    }


    var peopleList : ArrayList<People> = ArrayList()


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
        getAllPeople()
    }

    private fun getAllPeople() {
        AdapterRest.clientEndPoints?.getAllPeople()?.enqueue(object : Callback<PeopleList>{
            override fun onResponse(call: Call<PeopleList>, response: Response<PeopleList>) {

                peopleList.clear()
                peopleList = response.body()!!.result

            }

            override fun onFailure(call: Call<PeopleList>, t: Throwable) {
            }

        })
    }


}