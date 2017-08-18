package com.sheypoor.tvmaze.app.di

import com.sheypoor.tvmaze.app.TvMazeApplication
import com.sheypoor.tvmaze.app.di.module.AppModule
import com.sheypoor.tvmaze.app.di.module.NetworkModule
import com.sheypoor.tvmaze.pages.main.di.DaggerMainComponent
import com.sheypoor.tvmaze.pages.main.di.MainComponent

/**
 *  Created by Masoud Ashrafzadeh on 2017/08/17.
 */

object DependencyInjector {
    private var _mainComponent: MainComponent? = null

    var mainComponent: MainComponent? = null
        private set
        get() {
            if (_mainComponent == null)
                initMainComponent()
            return _mainComponent
        }

    var applicationComponent: ApplicationComponent? = null
        private set


    fun initApplicationComponent(tvMazeApplication: TvMazeApplication) {

        applicationComponent = DaggerApplicationComponent
                .builder()
                .appModule(AppModule(tvMazeApplication))
                .networkModule(NetworkModule())
                .build()
    }

    private fun initMainComponent() {
        _mainComponent = DaggerMainComponent
                .builder()
                .applicationComponent(applicationComponent)
                .build()
    }

}
