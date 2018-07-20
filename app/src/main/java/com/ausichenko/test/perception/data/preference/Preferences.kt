package com.ausichenko.test.perception.data.preference

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import javax.inject.Inject

class Preferences @Inject constructor(context: Context) {

    private val prefIsFirstStart = "is_first_start"
    private val prefNumberLength = "number_length"

    private val sharedPreferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    fun isFirstStart(): Boolean {
        return sharedPreferences.getBoolean(prefIsFirstStart, true)
    }

    fun setNonFirstStart() {
        sharedPreferences.edit().putBoolean(prefIsFirstStart, false).apply()
    }

    fun getNumberLength(): Int {
        return sharedPreferences.getInt(prefNumberLength, 3)
    }

    fun setNumberLength(numberLength: Int) {
        sharedPreferences.edit().putInt(prefNumberLength, numberLength).apply()
    }
}