package ru.alexnimas.imagesearchapp.data

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import ru.alexnimas.imagesearchapp.data.model.UnsplashPhoto

interface UnsplashRepository {
    fun getSearchResults(query: String): LiveData<PagingData<UnsplashPhoto>>
}