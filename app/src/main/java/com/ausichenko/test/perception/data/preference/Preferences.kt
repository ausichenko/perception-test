package com.ausichenko.test.perception.data.preference

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import javax.inject.Inject

class Preferences @Inject constructor(context: Context) {

    private val isFirstStart = "is_first_start"

    private val sharedPreferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    fun isFirstStart(): Boolean {
        return sharedPreferences.getBoolean(isFirstStart, true)
    }

    fun setNonFirstStart() {
        sharedPreferences.edit().putBoolean(isFirstStart, false).apply()
    }
}