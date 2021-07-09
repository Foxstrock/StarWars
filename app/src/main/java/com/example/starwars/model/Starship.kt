package com.example.starwars.model

import com.google.android.material.internal.ManufacturerUtils
import com.google.gson.annotations.SerializedName

data class Starship(

    @SerializedName("name")
    var name : String = "",

    @SerializedName("model")
    var model : String = "",

    @SerializedName("starship_class")
    var starship_class : String = "",

    @SerializedName("manufacturare")
    var manufacturare : String = "",

    @SerializedName("cost_in_credit")
    var cost_in_credit : String = "",

    @SerializedName("lenght")
    var crew : String = "",

    @SerializedName("passengers")
    var passengers : String = "",

    @SerializedName("max_atmosphering_speed")
    var max_atmosphering_speed : String = "",

    @SerializedName("hyperdrive_rating")
    var hyperdrive_rating : String = "" ,

    @SerializedName("MGLT")
    var mglt : String = "",

    @SerializedName("cargo_capacity")
    var cargo_capacity : String = "",

    @SerializedName("consumables")
    var consumables : String = "",

    @SerializedName("films")
    var films : ArrayList<Film> = ArrayList(),

    @SerializedName("pilots")
    var pilots : ArrayList<People> = ArrayList(),

    @SerializedName("url")
    var url : String = "",

    @SerializedName("created")
    var created : String = "",

    @SerializedName("edited")
    var edited : String = ""
)
