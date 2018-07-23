package com.ausichenko.test.perception.view.intro

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.ViewModel
import com.ausichenko.test.perception.PerceptionApplication
import com.ausichenko.test.perception.data.repository.Repository
import javax.inject.Inject

class IntroViewModel : ViewModel(), LifecycleObserver {

    @Inject lateinit var repository: Repository

    init {
        PerceptionApplication.appComponent.inject(this)
    }

    fun setNonFirstStart() {
        repository.setNonFirstStart()
    }
}