package com.example.starwars.model

import com.google.gson.annotations.SerializedName

data class Species(
    @SerializedName("name")
    var name : String = "",

    @SerializedName("classification")
    var classification : String = "",

    @SerializedName("designation")
    var designation : String = "",

    @SerializedName("average_height")
    var average_height : String = "",

    @SerializedName("average_lifespan")
    var average_lifespan : String = "",

    @SerializedName("eye_colors")
    var eye_colors : String = "",

    @SerializedName("hair_colors")
    var hair_colors : String = "",

    @SerializedName("skin_colors")
    var skin_colors : String = "",

    @SerializedName("language")
    var language : String = "",

    @SerializedName("homeworld")
    var homeworld : String = "",

    @SerializedName("people")
    var people : ArrayList<People> = ArrayList(),

    @SerializedName("url")
    var url : String = "",

    @SerializedName("created")
    var created : String = "",

    @SerializedName("edited")
    var edited : String = ""
)
