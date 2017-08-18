package com.sheypoor.tvmaze.base

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife

/**
 * Created by Masoud Ashrafzadeh on 2017/08/17.
 */
abstract class BaseActivity : AppCompatActivity() {

    abstract fun getContentView(): Int
    abstract fun resolveDependencies()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(getContentView())
        ButterKnife.bind(this)
        onViewReady(savedInstanceState, intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentView())
        ButterKnife.bind(this)
        onViewReady(savedInstanceState)
    }

    open fun onViewReady(savedInstanceState: Bundle?, intent: Intent?) {
        resolveDependencies()
    }

    open fun onViewReady(savedInstanceState: Bundle?) {
        resolveDependencies()
    }


}