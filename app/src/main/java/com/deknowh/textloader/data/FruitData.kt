package com.deknowh.textloader.data

import com.google.gson.annotations.SerializedName

data class FruitData(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("author")
    val author: String,
    @SerializedName("timestamp")
    val timestamp: Long
)
