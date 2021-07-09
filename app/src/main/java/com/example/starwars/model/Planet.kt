package com.example.starwars.model

import com.google.gson.annotations.SerializedName

data class Planet(

    @SerializedName("name")
    var name : String = "",

    @SerializedName("diameter")
    var diameter : String = "",

    @SerializedName("rotation_speed")
    var rotation_speed : String = "",

    @SerializedName("orbital_period")
    var orbital_period : String = "",

    @SerializedName("gravity")
    var gravity : String = "",

    @SerializedName("population")
    var population : String = "",

    @SerializedName("climate")
    var cliamte : String = "",

    @SerializedName("terrain")
    var terrain : String = "",

    @SerializedName("surface_water")
    var surface_water : String = "",

    @SerializedName("residents")
    var residents : ArrayList<People> = ArrayList(),

    @SerializedName("films")
    var films : ArrayList<Film> = ArrayList(),

    @SerializedName("url")
    var url : String = "",

    @SerializedName("created")
    var created : String = "",

    @SerializedName("edited")
    var edited : String = ""
)
