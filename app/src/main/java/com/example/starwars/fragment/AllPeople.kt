package com.example.starwars.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.starwars.R
import com.example.starwars.adapterRecycler.FilmRecyclerAdapter
import com.example.starwars.adapterRecycler.PeopleRecyclerAdapter
import com.example.starwars.databinding.FragmentAllPeopleBinding
import com.example.starwars.model.People
import com.example.starwars.model.PeopleList
import com.example.starwars.retrofit.AdapterRest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AllPeople : Fragment() , View.OnClickListener {

    var listaPersone : ArrayList<People> = ArrayList()


    val binding by lazy {
        FragmentAllPeopleBinding.inflate(layoutInflater)
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

        binding.listapersone.setOnClickListener(this)

    }


    override fun onResume() {
        super.onResume()
        getAllPeople()
    }

    private fun getAllPeople() {

        AdapterRest.clientEndPoints!!.getAllPeople().enqueue(object : Callback<PeopleList>{
            override fun onResponse(call: Call<PeopleList>, response: Response<PeopleList>) {

                listaPersone = response.body()!!.results
                initRecycler()

            }

            override fun onFailure(call: Call<PeopleList>, t: Throwable) {
                print("")
            }

        })

    }

    private fun initRecycler() {
        binding.listapersone.layoutManager = GridLayoutManager(requireContext() , 2)
        binding.listapersone.adapter = PeopleRecyclerAdapter(listaPersone , this)
    }

    override fun onClick(v: View?) {
        var url : String = listaPersone[binding.listapersone.getChildLayoutPosition(v!!)].url
        url = url.drop(28)
        url = url.dropLast(1)
        IdSingleton.url = url
        findNavController().navigate(R.id.action_allPeople_to_getPeopleInfo)

    }

}