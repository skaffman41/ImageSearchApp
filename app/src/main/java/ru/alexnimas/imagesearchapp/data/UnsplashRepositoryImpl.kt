package ru.alexnimas.imagesearchapp.data

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import ru.alexnimas.imagesearchapp.data.api.UnsplashApi
import ru.alexnimas.imagesearchapp.data.model.UnsplashPhoto
import ru.alexnimas.imagesearchapp.data.paging.UnsplashPagingSource
import javax.inject.Inject

class UnsplashRepositoryImpl @Inject constructor(
    private val unsplashApi: UnsplashApi
) : UnsplashRepository {

    override fun getSearchResults(query: String): LiveData<PagingData<UnsplashPhoto>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { UnsplashPagingSource(unsplashApi, query) }
        ).liveData
    }
}