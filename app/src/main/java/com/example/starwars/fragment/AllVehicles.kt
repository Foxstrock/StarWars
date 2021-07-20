package com.example.starwars.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.starwars.R
import com.example.starwars.adapterRecycler.VehicleAdapterRecycler
import com.example.starwars.databinding.FragmentAllVehiclesBinding
import com.example.starwars.model.Vehicle
import com.example.starwars.model.VehicleList
import com.example.starwars.retrofit.AdapterRest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AllVehicles : Fragment(), View.OnClickListener {

    var listaVeicoli : ArrayList<Vehicle> = ArrayList()

    var pag : Int = 1

    val binding by lazy {
        FragmentAllVehiclesBinding.inflate(layoutInflater)
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
        AdapterRest.clientEndPoints!!.getAllVehicle(pag.toString()).enqueue(object : Callback<VehicleList>{
            override fun onResponse(call: Call<VehicleList>, response: Response<VehicleList>) {

                listaVeicoli.addAll(response.body()!!.results)
                if (pag < 4){
                    pag++
                    getAllVehicle()
                }else {
                    initRecycler()
                }
            }

            override fun onFailure(call: Call<VehicleList>, t: Throwable) {

            }
        })
    }

    private fun initRecycler() {
        binding.listaveicoli.layoutManager = GridLayoutManager(requireContext() , 2 )
        binding.listaveicoli.adapter = VehicleAdapterRecycler(listaVeicoli , this::onClick)
    }

    override fun onClick(v: View?) {

        var url : String = listaVeicoli[binding.listaveicoli.getChildLayoutPosition(v!!)].url
        url = url.drop(31)
        url = url.dropLast(1)
        IdSingleton.url = url
        findNavController().navigate(R.id.action_allVehicles_to_getVehicleInfo)
    }


}