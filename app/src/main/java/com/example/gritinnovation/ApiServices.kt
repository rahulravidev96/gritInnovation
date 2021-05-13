package com.example.gritinnovation


import com.example.gritinnovation.model.MovieApi
import retrofit2.Call
import retrofit2.http.*

interface ApiServices {


    @GET("movie")
    fun getMovie(@Query("sort_by") sort: String, @Query("api_key") key: String): Call<MovieApi>

}