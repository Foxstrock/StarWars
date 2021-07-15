package com.example.starwars.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.starwars.databinding.FragmentGetPeopleInfoBinding
import com.example.starwars.fragment.IdSingleton.url
import com.example.starwars.model.People
import com.example.starwars.retrofit.AdapterRest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GetPeopleInfo : Fragment() {

    var peopleInfo : People = People()

    val binding by lazy{
        FragmentGetPeopleInfoBinding.inflate(layoutInflater)
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
        getPeopleInfo(url)
    }

    private fun getPeopleInfo(url : String) {
        AdapterRest.clientEndPoints!!.getPeopleInfo(url).enqueue(object : Callback<People> {
            override fun onResponse(call: Call<People>, response: Response<People>) {

                peopleInfo = response.body()!!
                initLayout()

            }

            override fun onFailure(call: Call<People>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun initLayout() {

        binding.name.text = peopleInfo.name
        binding.gender.text = peopleInfo.gender
        binding.birth.text = peopleInfo.birth_year
        binding.eye.text = peopleInfo.eye_color
        binding.skinColor.text = peopleInfo.skin_color

    }


}