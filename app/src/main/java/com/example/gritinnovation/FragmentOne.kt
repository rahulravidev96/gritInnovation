package com.example.gritinnovation

import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gritinnovation.model.MovieApi
import java.text.SimpleDateFormat
import java.util.*


class FragmentOne : Fragment() {
    private  lateinit var movieViewModel: MovieViewModel
    private  lateinit var movieAdapter: MovieAdapter
    var v:View?=null
    var rv:RecyclerView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieViewModel = ViewModelProvider(this).get(MovieViewModel::class.java)

        movieViewModel.getMovie("popularity.desc","45bf6592c14a965b33549f4cc7e6c664")
        observeDataSource()
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_one, container, false)
        rv = v!!.findViewById(R.id.rv)
        return v
    }

    private fun observeDataSource() {

        movieViewModel.getMovieToObserve().observe(this,{

            if (it!=null){
                setRecyclerView(it)
                    }


        })
    }

    private fun setRecyclerView(getResponse:MovieApi) {
        movieAdapter= MovieAdapter(context!!, getResponse)
        val llManager = LinearLayoutManager(requireContext())
        rv!!.layoutManager = llManager
        rv!!.setHasFixedSize(true)
        rv!!.adapter = movieAdapter
    }


}