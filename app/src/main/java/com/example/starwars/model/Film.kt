package com.example.starwars.model

import com.google.gson.annotations.SerializedName
import java.util.*
import kotlin.collections.ArrayList

data class Film(

    @SerializedName("title")
    var title : String = "",

    @SerializedName("episode_id")
    var episode_id : String = "",

    @SerializedName("opening_crawl")
    var opening_crawl : String = "",

    @SerializedName("director")
    var director : String = "",

    @SerializedName("relase_date")
    var relase_date : Date = Date(),

    @SerializedName("species")
    var species : ArrayList<String> = ArrayList(),

    @SerializedName("starships")
    var starships : ArrayList<String> = ArrayList(),

    @SerializedName("vehicles")
    var vehicles : ArrayList<String> = ArrayList(),

    @SerializedName("characters")
    var characters : ArrayList<String> = ArrayList(),

    @SerializedName("planets")
    var planets : ArrayList<String> = ArrayList(),

    @SerializedName("url")
    var url : String = "",

    @SerializedName("created")
    var created : String = "",

    @SerializedName("edited")
    var edited : String = ""


)
