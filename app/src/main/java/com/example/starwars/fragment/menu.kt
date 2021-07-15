package com.example.starwars.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import com.example.starwars.R
import com.example.starwars.databinding.FragmentMenuBinding

class menu : Fragment(), View.OnClickListener {


    val binding by lazy {
        FragmentMenuBinding.inflate(layoutInflater)
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

        binding.film.setOnClickListener(this)
        binding.people.setOnClickListener(this)


    }

    override fun onResume() {
        super.onResume()
    }

    override fun onClick(v: View?) {

        when (v!!.id){

            binding.film.id -> findNavController().navigate(R.id.action_menu_to_allFilm)

            binding.people.id -> findNavController().navigate(R.id.action_menu_to_allPeople)

        }

    }
}