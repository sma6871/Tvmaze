package com.sheypoor.tvmaze.pages.main.di

import com.sheypoor.tvmaze.app.di.ApplicationComponent
import com.sheypoor.tvmaze.app.di.PerActivity
import com.sheypoor.tvmaze.pages.main.MainActivity
import dagger.Component

/**
 * Created by Masoud Ashrafzadeh on 2017/08/17.
 */
@PerActivity
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(MainModule::class))
interface MainComponent {

    fun inject(mainActivity: MainActivity)

}