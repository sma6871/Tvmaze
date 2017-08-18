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
    var mainComponent: MainComponent? = null
        private set
        get() {
            if (mainComponent == null)
                initMainComponent()
            return mainComponent
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
        mainComponent = DaggerMainComponent
                .builder()
                .applicationComponent(applicationComponent)
                .build()
    }

}
