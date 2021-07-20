package com.example.starwars.retrofit

import com.example.starwars.model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ClientEndPoints {

    @GET("people")
    fun getAllPeople(@Query("page") pag : String) : Call<PeopleList>

    @GET("people/{id}")
    fun getPeopleInfo(@Path("id") id : String) : Call<People>

    @GET("films")
    fun getAllFilms() : Call<FilmList>

    @GET("films/{id}")
    fun getFilmInfo(@Path("id") id : String) : Call<Film>

    @GET("vehicles")
    fun getAllVehicle(@Query("page")pag : String) : Call<VehicleList>

    @GET("vehicles/{id}")
    fun getVehicleInfo(@Path("id") id : String) : Call<Vehicle>

    @GET("starships")
    fun getAllStarShip(@Query("page")pag : String) : Call<StarShipList>


}