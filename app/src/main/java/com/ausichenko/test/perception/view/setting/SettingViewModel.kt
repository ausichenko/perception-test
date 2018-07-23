package com.ausichenko.test.perception.view.setting

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.ViewModel
import com.ausichenko.test.perception.PerceptionApplication
import com.ausichenko.test.perception.data.repository.Repository
import javax.inject.Inject

class SettingViewModel : ViewModel(), LifecycleObserver {

    @Inject lateinit var repository: Repository

    init {
        PerceptionApplication.appComponent.inject(this)
    }

    fun getNumberLength(): Int {
        return repository.getNumberLength()
    }

    fun saveNumberLength(numberLength: Int) {
        repository.setNumberLength(numberLength)
    }
}