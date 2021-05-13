package com.example.gritinnovation

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.gritinnovation.model.MovieApi


class MovieAdapter(private val context: Context, private val getMovie: MovieApi) : RecyclerView.Adapter<MovieAdapter.ViewHolder>(){ private var view: View? = null

    override fun getItemCount() = getMovie.results!!.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view!!)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = getMovie.results!![position].originalTitle
        holder.desc.text = getMovie.results!![position].overview
        holder.date.text = getMovie.results!![position].releaseDate
        holder.rating.text = getMovie.results!![position].voteAverage!!.toDouble().toString()
        holder.card.setOnClickListener {
            val i = Intent(context,MainActivity2::class.java)
            i.putExtra("img",getMovie.results!![position].posterPath)
            i.putExtra("name",getMovie.results!![position].originalTitle)
            i.putExtra("overView",getMovie.results!![position].overview)
            i.putExtra("date",getMovie.results!![position].releaseDate.toString())
            i.putExtra("rating",getMovie.results!![position].voteAverage!!.toDouble().toString())
            i.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
            i.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
            context.startActivity(i)
        }






    }

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

        internal var name: TextView
        internal var date: TextView
        internal var desc: TextView
        internal var rating: TextView
        internal var card: CardView




        init {

            name = itemView.findViewById(R.id.name)
            date= itemView.findViewById(R.id.date)
            desc= itemView.findViewById(R.id.desc)
            rating= itemView.findViewById(R.id.rating)
            card= itemView.findViewById(R.id.card)

        }
    }
}