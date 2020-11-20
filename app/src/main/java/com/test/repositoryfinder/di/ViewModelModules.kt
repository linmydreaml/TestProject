package com.test.repositoryfinder.di

import com.test.repositoryfinder.search.SearchViewModel
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

val viewModelsModule = Kodein.Module("viewModelsModule") {
    bind<SearchViewModel>() with provider { SearchViewModel(instance()) }
}