package com.sheypoor.tvmaze.app

import com.orm.SugarApp
import com.sheypoor.tvmaze.app.di.DependencyInjector

/**
 *  Created by Masoud Ashrafzadeh on 2017/08/17.
 */
class TvMazeApplication : SugarApp() {

    override fun onCreate() {
        super.onCreate()

        DependencyInjector.initApplicationComponent(this)
    }

}