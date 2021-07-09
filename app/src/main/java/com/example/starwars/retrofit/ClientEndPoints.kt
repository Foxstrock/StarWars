package com.example.starwars.retrofit

import com.example.starwars.model.Film
import com.example.starwars.model.FilmList
import com.example.starwars.model.People
import com.example.starwars.model.PeopleList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ClientEndPoints {

    @GET("people")
    fun getAllPeople() : Call<PeopleList>

    @GET("people/:id")
    fun getPeopleInfo(@Path("id") id : Int) : Call<People>

    @GET("films")
    fun getAllFilms() : Call<FilmList>

    @GET("films/:id")
    fun getFilmInfo(@Path("id") id : Int) : Call<Film>
}