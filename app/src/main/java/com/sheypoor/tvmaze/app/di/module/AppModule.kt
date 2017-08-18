package com.sheypoor.tvmaze.app.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

import com.sheypoor.tvmaze.app.di.AppScope

import dagger.Module
import dagger.Provides

/**
 *  Created by Masoud Ashrafzadeh on 2017/08/17.
 */

@Module
class AppModule(application: Application) {

    private val context: Context = application.applicationContext


    @AppScope
    @Provides
    fun context(): Context {
        return context
    }

    @AppScope
    @Provides
    fun sharedPreferences(): SharedPreferences {
        return context.getSharedPreferences("tvmaze-prefs", Context.MODE_PRIVATE)
    }


}
