package ru.alexnimas.imagesearchapp.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.alexnimas.imagesearchapp.data.UnsplashRepository
import ru.alexnimas.imagesearchapp.data.UnsplashRepositoryImpl
import ru.alexnimas.imagesearchapp.data.api.UnsplashApi
import ru.alexnimas.imagesearchapp.data.api.UnsplashApi.Companion.BASE_URL
import javax.inject.Singleton

@Module(includes = [AppModule.AppModuleBinds::class])
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesLoggingInterceptor() =
        HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }

    @Singleton
    @Provides
    fun providesOkHttpClient(loggingInterceptor: HttpLoggingInterceptor) =
        OkHttpClient.Builder().apply {
            addInterceptor(loggingInterceptor)
        }.build()

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit): UnsplashApi = retrofit.create(UnsplashApi::class.java)

    @Module
    @InstallIn(ApplicationComponent::class)
    interface AppModuleBinds {
        @Singleton
        @Binds
        fun bindUnsplashRepository(unsplashRepository: UnsplashRepositoryImpl): UnsplashRepository
    }
}