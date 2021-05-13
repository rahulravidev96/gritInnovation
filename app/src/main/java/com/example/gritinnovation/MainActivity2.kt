package com.example.gritinnovation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class MainActivity2 : AppCompatActivity() {
    private var titles: String? = null
    private var image: String? = null
    private var summary: String? = null
    private var ratings: String? = null
    private var datee: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


            if (intent != null) {
                titles = intent.extras!!.getString("name")
                image = intent.extras!!.getString("img")
                summary = intent.extras!!.getString("overView")
                ratings = intent.extras!!.getString("rating")
                datee = intent.extras!!.getString("date")
            }

            var title = findViewById<TextView>(R.id.name)
            var date = findViewById<TextView>(R.id.releasedate)
            var summry = findViewById<TextView>(R.id.summary)
            var rating = findViewById<TextView>(R.id.rating)
            var img = findViewById<ImageView>(R.id.imageView)


            title.text = titles
            summry.text = summary
            rating.text = ratings.toString()
            date.text = datee.toString()

            Glide
                .with(this)
                .load("https://image.tmdb.org/t/p/w500$image")
                .into(img)


    }
}