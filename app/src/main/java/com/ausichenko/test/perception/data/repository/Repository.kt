package com.ausichenko.test.perception.data.repository

import com.ausichenko.test.perception.data.preference.Preferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
        private val preferences: Preferences
) {

    fun isFirstStart(): Boolean {
        return preferences.isFirstStart()
    }

    fun setNonFirstStart() {
        preferences.setNonFirstStart()
    }

    fun getNumberLength(): Int {
        return preferences.getNumberLength()
    }

    fun setNumberLength(numberLength: Int) {
        preferences.setNumberLength(numberLength)
    }
}