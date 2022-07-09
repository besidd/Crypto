package com.example.crypto.di

import com.example.crypto.common.Constants.BASE_URL
import com.example.crypto.data.remote.CoinPaprikaAPI
import com.example.crypto.data.repository.CoinRepositoryImpl
import com.example.crypto.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaAPI {
        val logging = HttpLoggingInterceptor()
        val httpClient = OkHttpClient.Builder()
        logging.level = HttpLoggingInterceptor.Level.BODY
        httpClient.addInterceptor(logging)
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaAPI): CoinRepository {
        return CoinRepositoryImpl(api)
    }

}