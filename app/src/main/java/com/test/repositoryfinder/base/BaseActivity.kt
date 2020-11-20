package com.test.repositoryfinder.base


import androidx.fragment.app.FragmentActivity
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

abstract class BaseActivity : FragmentActivity(), KodeinAware {

    override val kodein: Kodein by lazy{
        (this.applicationContext as KodeinAware).kodein
    }
}