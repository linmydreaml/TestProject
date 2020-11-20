package com.test.repositoryfinder.common

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.test.repositoryfinder.ViewModelFactory

import org.kodein.di.KodeinAware
import org.kodein.di.direct
import org.kodein.di.generic.instance

inline fun <reified VM : ViewModel, T> T.viewModel(): Lazy<VM> where T : KodeinAware, T : LifecycleOwner, T : ViewModelStoreOwner {
    return lazy(LazyThreadSafetyMode.NONE) {
        ViewModelProvider(
            this,
            direct.instance<ViewModelFactory>()
        )[VM::class.java]
    }
}