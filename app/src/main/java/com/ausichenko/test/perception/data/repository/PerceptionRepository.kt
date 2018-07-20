package com.ausichenko.test.perception.data.repository

import com.ausichenko.test.perception.data.preference.Preferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PerceptionRepository @Inject constructor(
        private val preferences: Preferences
) : Repository {

    override fun isFirstStart(): Boolean {
        return preferences.isFirstStart()
    }

    override fun setNonFirstStart() {
        preferences.setNonFirstStart()
    }

    override fun getNumberLength(): Int {
        return preferences.getNumberLength()
    }

    override fun setNumberLength(numberLength: Int) {
        preferences.setNumberLength(numberLength)
    }
}