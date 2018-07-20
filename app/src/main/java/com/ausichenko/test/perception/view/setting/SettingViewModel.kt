package com.ausichenko.test.perception.view.setting

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.ViewModel
import com.ausichenko.test.perception.PerceptionApplication
import com.ausichenko.test.perception.data.repository.PerceptionRepository
import javax.inject.Inject

class SettingViewModel : ViewModel(), LifecycleObserver {

    @Inject lateinit var perceptionRepository: PerceptionRepository

    init {
        PerceptionApplication.appComponent.inject(this)
    }

    fun getNumberLength(): Int {
        return perceptionRepository.getNumberLength()
    }

    fun saveNumberLength(numberLength: Int) {
        perceptionRepository.setNumberLength(numberLength)
    }
}