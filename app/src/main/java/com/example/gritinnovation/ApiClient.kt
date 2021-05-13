package com.example.gritinnovation

import android.content.Context
import com.google.gson.GsonBuilder
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

class ApiClient {
    companion object {
        var networkService: ApiServices? = null
        private var mContext: Context? = null
        var retrofit: Retrofit? = null
        val BASE_URL = "https://api.themoviedb.org/3/discover/"


        fun getApiObj(): ApiServices? {

            val okHttpClient = OkHttpClient.Builder()
                .readTimeout(120, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
                .connectTimeout(120, TimeUnit.SECONDS)
                .build()

            if (retrofit == null && BASE_URL.isNotEmpty()) {
                retrofit = Retrofit.Builder().addConverterFactory(
                    GsonConverterFactory.create(
                        GsonBuilder().create()
                    )
                )
                    .client(okHttpClient)
                    .baseUrl(BASE_URL).build()
            }
            return retrofit!!.create(ApiServices::class.java)

        }
    }

}