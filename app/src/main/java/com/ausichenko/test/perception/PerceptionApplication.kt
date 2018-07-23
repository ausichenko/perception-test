package com.ausichenko.test.perception

import android.app.Application
import com.ausichenko.test.perception.di.AppComponent
import com.ausichenko.test.perception.di.AppModule
import com.ausichenko.test.perception.di.DaggerAppComponent

class PerceptionApplication : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
}