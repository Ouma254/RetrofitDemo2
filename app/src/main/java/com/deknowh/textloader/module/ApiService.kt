package com.deknowh.textloader.module

import com.deknowh.textloader.data.FruitData
import retrofit2.http.GET
import retrofit2.http.PUT

interface ApiService {
    // get data from the Api
    @GET("posts/all")
    suspend fun getFruits() : List<FruitData> // function to return the data
}