package com.test.repositoryfinder.network

import com.test.repositoryfinder.model.SearchResultModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/search/repositories")
    fun searchByWord(@Query("q") q: String,
                     @Query("sort") sort: String,
                     @Query("order") order: String,
                     @Query("page") page: String,
                     @Query("per_page") per_page: String
    ) : Single<SearchResultModel>
}