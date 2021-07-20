package com.example.starwars.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.starwars.R
import com.example.starwars.adapterRecycler.StarShipRecyclerAdapter
import com.example.starwars.databinding.FragmentAllStarShipBinding
import com.example.starwars.model.StarShipList
import com.example.starwars.model.Starship
import com.example.starwars.retrofit.AdapterRest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AllStarShip : Fragment(), View.OnClickListener {

    var listaNavi : ArrayList<Starship> = ArrayList()

    var pag : Int = 1

    val binding by lazy {

        FragmentAllStarShipBinding.inflate(layoutInflater)

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
        getAllShip()
    }

    private fun getAllShip() {

        AdapterRest.clientEndPoints!!.getAllStarShip(pag.toString()).enqueue(object : Callback<StarShipList>{
            override fun onResponse(call: Call<StarShipList>, response: Response<StarShipList>) {

                listaNavi.addAll(response.body()!!.results)
                if(pag < 4){
                    pag++
                    getAllShip()
                }else {
                    initRecycler()
                }
            }

            override fun onFailure(call: Call<StarShipList>, t: Throwable) {
                print("")
            }
        })

    }

    private fun initRecycler() {
        binding.listaNaviSpaziali.layoutManager = GridLayoutManager(requireContext() , 2)
        binding.listaNaviSpaziali.adapter = StarShipRecyclerAdapter(listaNavi , this)
    }

    override fun onClick(v: View?) {

    }

}