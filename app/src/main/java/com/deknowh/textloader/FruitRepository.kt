package com.deknowh.textloader

import com.deknowh.textloader.data.FruitData
import com.deknowh.textloader.module.ApiService

class FruitRepository(private val apiService: ApiService) {
    // fetch the data from the apiService
    suspend fun fetchFruits() : List<FruitData> {
        return apiService.getFruits()
    }
}