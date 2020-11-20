package com.test.repositoryfinder.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

abstract class BaseFragment: Fragment(), KodeinAware {

    override val kodein: Kodein by lazy{
        (context as KodeinAware).kodein
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(getLayoutId(), container, false)
    }

    @LayoutRes
    abstract fun getLayoutId(): Int
}