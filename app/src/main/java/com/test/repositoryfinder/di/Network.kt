package com.test.repositoryfinder.di

import com.test.repositoryfinder.BuildConfig
import com.test.repositoryfinder.network.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance

import org.kodein.di.generic.singleton

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = Kodein.Module("Network Module") {
    bind<OkHttpClient>() with singleton { getOkHttpClient() }
    bind<Retrofit>() with singleton { getRetrofit(instance()) }
    bind<ApiService>() with singleton { getApiService(instance()) }
}

private fun getOkHttpClient(): OkHttpClient {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.apply { loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY }
    return OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor).build()
}

private fun getRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
    .baseUrl(BuildConfig.API_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
    .client(okHttpClient)
    .build()

private fun getApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)
