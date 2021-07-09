package com.example.starwars.model

import com.google.gson.annotations.SerializedName

data class PeopleList(

    @SerializedName("count")
    var count : String = "",

    @SerializedName("next")
    var next : String = "",

    @SerializedName("previous")
    var previous : String = "",

    @SerializedName("result")
    var result : ArrayList<People> = ArrayList()
)
