package com.example.starwars.retrofit

import com.example.starwars.model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ClientEndPoints {

    @GET("people")
    fun getAllPeople() : Call<PeopleList>

    @GET("people/{id}")
    fun getPeopleInfo(@Path("id") id : String) : Call<People>

    @GET("films")
    fun getAllFilms() : Call<FilmList>

    @GET("films/{id}")
    fun getFilmInfo(@Path("id") id : String) : Call<Film>

    @GET("vehicles")
    fun getAllVehicle() : Call<VehicleList>

    @GET("vehicles/{id}")
    fun getVehicleInfo(@Path("id") id : String) : Call<Vehicle>
}