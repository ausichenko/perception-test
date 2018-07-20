package com.ausichenko.test.perception.di

import com.ausichenko.test.perception.view.MainViewModel
import com.ausichenko.test.perception.view.intro.IntroViewModel
import dagger.Component
import javax.inject.Singleton

@Component(modules = [(AppModule::class)])
@Singleton interface AppComponent {

    fun inject(mainViewModel: MainViewModel)
    fun inject(introViewModel: IntroViewModel)
}