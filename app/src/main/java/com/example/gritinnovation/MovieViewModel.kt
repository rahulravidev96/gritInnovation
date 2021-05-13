package com.example.gritinnovation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.gritinnovation.model.MovieApi


class MovieViewModel:ViewModel() {
    private var repository: Repository = Repository()
    private var movieResponse : LiveData<MovieApi>

    init {
        movieResponse = repository.getMovieLiveDta()
    }

    fun getMovieToObserve(): LiveData<MovieApi> {
        return movieResponse
    }
    fun getMovie(sort: String,key:String){
        repository.getMovie(sort,key)
    }
}