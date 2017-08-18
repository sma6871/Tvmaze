package com.sheypoor.tvmaze.app.di

import android.content.Context
import android.content.SharedPreferences

import com.google.gson.Gson
import com.sheypoor.tvmaze.app.di.module.AppModule
import com.sheypoor.tvmaze.app.di.module.NetworkModule
import com.sheypoor.tvmaze.network.TvMazeApiService

import dagger.Component
import okhttp3.OkHttpClient

/**
 *  Created by Masoud Ashrafzadeh on 2017/08/17.
 * Application component for global dependencies
 */

@AppScope
@Component(modules = arrayOf(NetworkModule::class, AppModule::class))
interface ApplicationComponent {

    fun context(): Context

    fun okHttpClient(): OkHttpClient

    fun tvMazeApiService(): TvMazeApiService

    fun sharedPreferences(): SharedPreferences

    fun gson(): Gson
}
