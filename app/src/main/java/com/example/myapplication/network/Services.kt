package com.example.myapplication.network

import com.example.myapplication.Constants.BASEURL
import com.example.myapplication.model.ApiListResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface Services {

    @GET("repositories")
    suspend fun getListApi(@Query("since") since : Int): List<ApiListResponse>


    companion object {

        fun createService(
            httpClient: HttpClientBuilderFactory
        ): Services {

            val okHttpClient = httpClient.create().build()

            return Retrofit.Builder()
                .baseUrl(BASEURL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Services::class.java)
        }
    }
}