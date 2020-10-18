package ru.alexnimas.imagesearchapp.data.api

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import ru.alexnimas.imagesearchapp.BuildConfig
import ru.alexnimas.imagesearchapp.data.model.GeneralUnsplashModel

interface UnsplashApi {

    @Headers("Accept-Version: v1", "Authorization: Client-ID $CLIENT_ID")
    @GET("search/photos")
    suspend fun searchPhotos(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): GeneralUnsplashModel

    companion object {
        const val BASE_URL = "https://api.unsplash.com/"
        const val CLIENT_ID = BuildConfig.UNSPLASH_ACCESS_KEY
    }
}