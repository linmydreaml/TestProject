package com.test.repositoryfinder.model


import Items
import com.google.gson.annotations.SerializedName

data class SearchResultModel(
    @SerializedName("total_count") val total_count : Int,
    @SerializedName("incomplete_results") val incomplete_results : Boolean,
    @SerializedName("items") val items : List<Items>)