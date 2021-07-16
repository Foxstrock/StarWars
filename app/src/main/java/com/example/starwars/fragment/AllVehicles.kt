package com.example.starwars.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.starwars.R
import com.example.starwars.databinding.FragmentGetAllVehiclesBinding
import com.example.starwars.model.PeopleList
import com.example.starwars.model.Vehicle
import com.example.starwars.model.VehicleList
import com.example.starwars.retrofit.AdapterRest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AllVehicles : Fragment(), View.OnClickListener {

    var listaVeicoli : ArrayList<Vehicle> = ArrayList()

    val binding by lazy {
        FragmentGetAllVehiclesBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.listaveicoli.setOnClickListener(this)
    }

    override fun onResume() {
        super.onResume()
        getAllVehicle()
    }

    private fun getAllVehicle() {
        AdapterRest.clientEndPoints!!.getAllVehicle().enqueue(object : Callback<VehicleList>{
            override fun onResponse(call: Call<VehicleList>, response: Response<VehicleList>) {

                listaVeicoli = response.body()!!.results
                initRecycler()

            }

            override fun onFailure(call: Call<VehicleList>, t: Throwable) {

            }
        })
    }

    private fun initRecycler() {
        binding.listaveicoli.layoutManager = GridLayoutManager(requireContext() , 2 )
        binding.listaveicoli.adapter =
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }


}