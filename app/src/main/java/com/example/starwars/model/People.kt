package com.example.starwars.model

import com.google.gson.annotations.SerializedName

data class People(

    @SerializedName("name")
    var name : String = "",

    @SerializedName("birth_year")
    var birth_year : String = "",

    @SerializedName("eye_color")
    var eye_color : String = "",

    @SerializedName("gender")
    var gender : String = "",

    @SerializedName("height")
    var height : String = "",

    @SerializedName("mass")
    var mass : String = "",

    @SerializedName("skin_color")
    var skin_color : String = "",

    @SerializedName("homeworld")
    var homeworld : String = "",

    @SerializedName("films")
    var films : ArrayList<String> = ArrayList(),

    @SerializedName("species")
    var species : ArrayList<String> = ArrayList(),

    @SerializedName("starships")
    var starships : ArrayList<String> = ArrayList(),

    @SerializedName("vehicles")
    var vehicles : ArrayList<String> = ArrayList(),

    @SerializedName("url")
    var url : String = "",

    @SerializedName("created")
    var created : String = "",

    @SerializedName("edited")
    var edited : String = ""
)
