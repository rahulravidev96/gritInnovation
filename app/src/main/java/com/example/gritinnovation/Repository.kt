package com.example.gritinnovation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.gritinnovation.model.MovieApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class Repository {

    var apiServices: ApiServices = ApiClient.getApiObj()!!
    var getmovieLiveData: MutableLiveData<MovieApi> = MutableLiveData()


    fun getMovieLiveDta(): MutableLiveData<MovieApi>{
        return getmovieLiveData
    }

    fun getMovie(sort: String,key: String){

        apiServices.getMovie(sort,key).enqueue(object : Callback<MovieApi> {

            override fun onResponse(call: Call<MovieApi>, response: Response<MovieApi>) {
                if(response.isSuccessful){
                    getmovieLiveData.postValue(response.body())
                }else{
                    getmovieLiveData.postValue(null)
                }
            }

            override fun onFailure(call: Call<MovieApi>, t: Throwable) {
                getmovieLiveData.postValue(null)
            }

        })

    }



}