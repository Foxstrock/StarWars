package com.example.starwars.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
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


class GetVehicleInfo : Fragment(), View.OnClickListener {

    var vehicleInfo : Vehicle = Vehicle()
    var filmCorrelate : Film = Film()
    var arrayFilm : ArrayList<Film> = ArrayList()
    var idCor : String = ""
    var i : Int = 0
    var max : Int = 0

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

        binding.filmcorrelate.setOnClickListener(this)

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

        binding.crew.text="Crew : "+vehicleInfo.crew
        binding.vehiclenameinfo.text = "Name : " + vehicleInfo.name
        binding.vehiclemodelinfo.text = "Model : "+vehicleInfo.model
        binding.vehicleclassinfo.text = "Class : "+vehicleInfo.vehicle_class
        binding.vehiclemanufainfo.text = "manufacturer"+vehicleInfo.manufacturer
        binding.vehiclelenghtinfo.text = "length : " + vehicleInfo.lenght
        binding.vehiclecostinfo.text =   "cost_in_credits : " + vehicleInfo.cost_in_credits
        binding.vehicleAtmoSpeedInfo.text = "max_atmosphering_speed : "+vehicleInfo.max_atmosphering_speed
        binding.vehicleConsumableInfo.text = "Consumable : "+vehicleInfo.consumables
        binding.vehiclecargoinfo.text = "Cargo capacity : "+vehicleInfo.cargo_capacity
        binding.vehiclepassengerinfo.text = "Passenger : "+vehicleInfo.passengers
        binding.vehiclelastInfo.text = "Created : " + vehicleInfo.created + " \n "  + "Edited : " + vehicleInfo.edited

            max = vehicleInfo.films.size - 1
            idCor = vehicleInfo.films[i]
            idCor = idCor.drop(28)
            idCor = idCor.dropLast(1)
            getFilmInfo(idCor)


    }


    private fun getFilmInfo(id : String) {

        AdapterRest.clientEndPoints!!.getFilmInfo(id).enqueue(object : Callback<Film> {
            override fun onResponse(call: Call<Film>, response: Response<Film>) {

                filmCorrelate = response.body()!!
                arrayFilm.addAll(listOf(filmCorrelate))
                if(i < max){
                    i++
                    idCor = vehicleInfo.films[i]
                    idCor = idCor.drop(28)
                    idCor = idCor.dropLast(1)
                    getFilmInfo(idCor)
                }else{
                    initRecyclerfilm()
                }


            }

            override fun onFailure(call: Call<Film>, t: Throwable) {
                print("")
            }
        })

    }


    private fun initRecyclerfilm() {
        binding.filmcorrelate.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding.filmcorrelate.adapter = CorrelateAdapter(arrayFilm , this)
    }


    override fun onClick(v: View?) {

        var url : String = arrayFilm[binding.filmcorrelate.getChildLayoutPosition(v!!)].url
        url = url.drop(28)
        url = url.dropLast(1)
        IdSingleton.url = url
       findNavController().navigate(R.id.action_getVehicleInfo_to_getInfoFilm)
    }


}