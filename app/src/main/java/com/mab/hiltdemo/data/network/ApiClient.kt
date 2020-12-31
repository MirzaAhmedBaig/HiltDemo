package com.mab.hiltdemo.data.network

import com.mab.hiltdemo.data.network.NetworkConstants.BASE_URL
import com.mab.hiltdemo.data.network.NetworkConstants.DEBUG
import com.mab.hiltdemo.data.network.NetworkConstants.REQUEST_TIMEOUT_DURATION
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(ActivityComponent::class)
object ApiClient {
    @Provides
    operator fun invoke(networkConnectionInterceptor: NetworkConnectionInterceptor): ApiManager {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(getFactory()))
            .client(createRequestInterceptorClient(networkConnectionInterceptor))
            .build()
            .create(ApiManager::class.java)
    }

    private fun getFactory() = GsonBuilder()
        .enableComplexMapKeySerialization()
        .setPrettyPrinting()
        .create()

    private fun createRequestInterceptorClient(networkConnectionInterceptor: NetworkConnectionInterceptor): OkHttpClient {

        return if (DEBUG) {
            OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .connectTimeout(REQUEST_TIMEOUT_DURATION.toLong(), TimeUnit.SECONDS)
                .readTimeout(REQUEST_TIMEOUT_DURATION.toLong(), TimeUnit.SECONDS)
                .writeTimeout(REQUEST_TIMEOUT_DURATION.toLong(), TimeUnit.SECONDS)
                .build()
        } else {
            OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .connectTimeout(REQUEST_TIMEOUT_DURATION.toLong(), TimeUnit.SECONDS)
                .readTimeout(REQUEST_TIMEOUT_DURATION.toLong(), TimeUnit.SECONDS)
                .writeTimeout(REQUEST_TIMEOUT_DURATION.toLong(), TimeUnit.SECONDS)
                .build()
        }
    }
}