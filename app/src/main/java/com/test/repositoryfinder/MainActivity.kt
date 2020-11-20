package com.test.repositoryfinder

import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.test.repositoryfinder.base.BaseActivity
import com.test.repositoryfinder.search.SearchFragment


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState != null) {
            return
        }
        supportFragmentManager.commit {
            add<SearchFragment>(R.id.container, null, intent.extras)
        }

    }


}