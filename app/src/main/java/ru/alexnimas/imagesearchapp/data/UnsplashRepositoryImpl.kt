package ru.alexnimas.imagesearchapp.data

import ru.alexnimas.imagesearchapp.data.api.UnsplashApi
import javax.inject.Inject
import javax.inject.Singleton

class UnsplashRepositoryImpl @Inject constructor(
    private val unsplashApi: UnsplashApi
) : UnsplashRepository {

}