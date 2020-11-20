package com.test.repositoryfinder.search


import Items
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.repositoryfinder.model.SearchResultModel
import com.test.repositoryfinder.network.ApiService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.BiFunction

import io.reactivex.rxjava3.schedulers.Schedulers

class SearchViewModel(private val api: ApiService) : ViewModel() {

    private val searchModel = MutableLiveData<ArrayList<Items>>()
    val searchModelLiveData: LiveData<ArrayList<Items>> = searchModel

    fun searchRepo(name: String) {

        val request = Single.zip(api.searchByWord(name, "stars", "desc", "1","15"),
            api.searchByWord(name, "stars", "desc", "2","15"),
            BiFunction<SearchResultModel,SearchResultModel,ArrayList<Items>> { item1, item2 ->
                var mergedList = ArrayList<Items>()
                mergedList.addAll(item1.items)
                mergedList.addAll(item2.items)
                mergedList
            })

        request.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<ArrayList<Items>> {
                override fun onSubscribe(d: Disposable?) {
                }

                override fun onError(e: Throwable?) {
                }

                override fun onSuccess(t: ArrayList<Items>?) {
                    searchModel.value = t
                }

            })
    }
}