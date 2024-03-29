package com.deknowh.textloader.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deknowh.textloader.data.FruitData
import com.deknowh.textloader.module.ApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class FruitViewModel : ViewModel() {
    private val retrofitService = Retrofit.Builder() // retrofit object
        .baseUrl("https://jsonplaceholder.typicode.com/") // url to api
        .addConverterFactory(GsonConverterFactory.create()) //serializes the output
        .build()// builds the output
        .create(ApiService::class.java)

    // object
    private val myFruit = MutableStateFlow<List<FruitData>>(emptyList())
    val fruitData: StateFlow<List<FruitData>> = myFruit

    // fetch the fruits
    fun fetchFruits() {
        // viewmodel object
        viewModelScope.launch {
            try {
                val fruit = retrofitService.getFruits()
                myFruit.value = fruit
            } catch (e: Exception) {
                when(e) {
                    is IOException -> {
                        Log.e("Network Error", "No Internet connection")
                    }
                    is HttpException -> {
                        val statusCode = e.code()
                        val errorMessage = e.message()
                        // print error
                        Log.e("HttpError","HttpError: $statusCode - $errorMessage")
                    } else -> {
                        // other Error
                        Log.e("Other Error", "Error: ${e.message}")
                    }
                }
            }
        }
    }
}