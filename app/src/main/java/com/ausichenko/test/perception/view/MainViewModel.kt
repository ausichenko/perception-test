package com.ausichenko.test.perception.view

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.ViewModel
import com.ausichenko.test.perception.PerceptionApplication
import com.ausichenko.test.perception.data.repository.PerceptionRepository
import javax.inject.Inject

class MainViewModel : ViewModel(), LifecycleObserver {

    @Inject lateinit var perceptionRepository: PerceptionRepository

    init {
        PerceptionApplication.appComponent.inject(this)
    }

    fun isFirstStart(): Boolean {
        return perceptionRepository.isFirstStart()
    }
}