package com.test.repositoryfinder

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.repositoryfinder.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.TT
import org.kodein.di.direct

class ViewModelFactory(appContext: Context) : ViewModelProvider.Factory, KodeinAware {
    override val kodein: Kodein =
        (appContext as Application).kodein

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        kodein.direct.Instance(TT(modelClass))
}