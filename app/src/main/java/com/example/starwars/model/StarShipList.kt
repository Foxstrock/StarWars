package com.example.starwars.model

import com.google.gson.annotations.SerializedName

data class StarShipList(

    @SerializedName("count")
    var count : Int = 0,

    @SerializedName("next")
    var next : Any? = null,

    @SerializedName("previous")
    var previous : Any? = null,

    @SerializedName("results")
    var results : ArrayList<Starship> = ArrayList()

)
