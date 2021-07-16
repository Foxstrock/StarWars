package com.example.starwars.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.starwars.R
import com.example.starwars.adapterRecycler.CorrelateAdapter
import com.example.starwars.databinding.FragmentGetVehicleInfoBinding
import com.example.starwars.model.Film
import com.example.starwars.model.Vehicle
import com.example.starwars.retrofit.AdapterRest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GetVehicleInfo : Fragment() {

    var vehicleInfo : Vehicle = Vehicle()
    var filmCorrelate : ArrayList<Film> = ArrayList()

    val binding by lazy {
        FragmentGetVehicleInfoBinding.inflate(layoutInflater)
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
    }

    override fun onResume() {
        super.onResume()
        getInfoVehicle(IdSingleton.url)
    }

    private fun getInfoVehicle(id : String) {

        AdapterRest.clientEndPoints!!.getVehicleInfo(id).enqueue(object : Callback<Vehicle>{
            override fun onResponse(call: Call<Vehicle>, response: Response<Vehicle>) {

                vehicleInfo = response.body()!!
                initLayout()
            }

            override fun onFailure(call: Call<Vehicle>, t: Throwable) {

                print("")

            }
        })

    }

    private fun initLayout() {

        filmCorrelate(id)

        binding.crew.text=vehicleInfo.crew
        binding.vehiclenameinfo.text = vehicleInfo.name
        binding.vehiclemodelinfo.text = vehicleInfo.model
        binding.vehicleclassinfo.text = vehicleInfo.vehicle_class
        binding.vehiclemanufainfo.text = vehicleInfo.manufacturare
        binding.vehiclelenghtinfo.text = vehicleInfo.lenght
        binding.vehiclecostinfo.text = vehicleInfo.cost_in_credit
        binding.vehicleAtmoSpeedInfo.text = vehicleInfo.max_atmosphering_speed
        binding.vehicleConsumableInfo.text = vehicleInfo.consumables
        binding.vehiclecargoinfo.text = vehicleInfo.cargo_capacity
        binding.vehiclepassengerinfo.text = vehicleInfo.passengers
        binding.vehiclelastInfo.text = "Created : " + vehicleInfo.created + " \n "  + "Edited : " + vehicleInfo.edited
    }

    private fun filmCorrelate(id: String) {
        AdapterRest.clientEndPoints!!.getFilmInfo(id).enqueue(object : Callback<Film>{
            override fun onResponse(call: Call<Film>, response: Response<Film>) {

                filmCorrelate = response.body()!!.
                initRecycler()

            }

            override fun onFailure(call: Call<Film>, t: Throwable) {
                print("")
            }
        })
    }

    private fun initRecycler() {
        binding.filmcorrelate.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding.filmcorrelate.adapter = CorrelateAdapter(filmCorrelate , this)
    }
}