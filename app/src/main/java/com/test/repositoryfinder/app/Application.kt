package com.test.repositoryfinder.app

import android.app.Application
import com.test.repositoryfinder.ViewModelFactory
import com.test.repositoryfinder.di.networkModule
import com.test.repositoryfinder.di.viewModelsModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton



class Application : Application() , KodeinAware {

    override val kodein: Kodein by Kodein.lazy {
        bind<ViewModelFactory>() with singleton {
            ViewModelFactory(
                applicationContext
            )
        }
        import(viewModelsModule)
        import(networkModule)
    }

}