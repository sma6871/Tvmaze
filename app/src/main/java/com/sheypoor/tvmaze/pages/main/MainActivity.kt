package com.sheypoor.tvmaze.pages.main

import android.content.Intent
import android.os.Bundle
import com.sheypoor.tvmaze.R
import com.sheypoor.tvmaze.app.di.DependencyInjector
import com.sheypoor.tvmaze.base.BaseActivity
import com.sheypoor.tvmaze.utils.ActivityUtils

class MainActivity : BaseActivity() {


    override fun getContentView() = R.layout.activity_main

    override fun resolveDependencies() {
        DependencyInjector.mainComponent?.inject(this)
    }

    override fun onViewReady(savedInstanceState: Bundle?, intent: Intent?) {
        super.onViewReady(savedInstanceState, intent)
        val fragment = MoviesListFragment.newInstance()
        ActivityUtils.replaceFragment(supportFragmentManager, fragment,R.id.listFragmentHolder)

        MoviesListFragmentPresenter(fragment)


    }

}
