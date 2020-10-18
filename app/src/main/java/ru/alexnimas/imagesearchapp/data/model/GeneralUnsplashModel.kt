package ru.alexnimas.imagesearchapp.data.model

import com.google.gson.annotations.SerializedName

data class GeneralUnsplashModel(
    val total: Int?,
    @SerializedName("total_pages") val totalPages: Int?,
    val results: List<UnsplashPhoto>
)