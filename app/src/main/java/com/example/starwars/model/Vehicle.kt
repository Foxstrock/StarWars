package com.example.starwars.model

import com.google.gson.annotations.SerializedName

data class Vehicle(

    @SerializedName("name")
    var name : String = "",

    @SerializedName("model")
    var model : String = "",

    @SerializedName("vehicle_class")
    var vehicle_class : String = "",

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
