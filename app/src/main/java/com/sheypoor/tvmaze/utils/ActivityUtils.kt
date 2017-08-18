package com.sheypoor.tvmaze.utils

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

/**
 * Created by Masoud Ashrafzadeh on 2017/08/17.
 */
object ActivityUtils {
    fun replaceFragment(fragmentManager: FragmentManager, fragment: Fragment, fragmentId: Int) {
        fragmentManager.beginTransaction().replace(fragmentId, fragment).commit()
    }
}