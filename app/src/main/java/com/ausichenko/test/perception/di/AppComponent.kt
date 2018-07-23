package com.ausichenko.test.perception.di

import com.ausichenko.test.perception.view.MainViewModel
import com.ausichenko.test.perception.view.input.InputFragment
import com.ausichenko.test.perception.view.intro.IntroActivity
import com.ausichenko.test.perception.view.intro.IntroViewModel
import com.ausichenko.test.perception.view.result.ResultFragment
import com.ausichenko.test.perception.view.setting.SettingFragment
import com.ausichenko.test.perception.view.setting.SettingViewModel
import com.ausichenko.test.perception.view.show.ShowFragment
import com.ausichenko.test.perception.view.show.ShowViewModel
import dagger.Component
import javax.inject.Singleton

@Component(modules = [(AppModule::class)])
@Singleton interface AppComponent {

    fun inject(mainViewModel: MainViewModel)
    fun inject(introActivity: IntroActivity)
    fun inject(introViewModel: IntroViewModel)

    fun inject(settingFragment: SettingFragment)
    fun inject(settingViewModel: SettingViewModel)
    fun inject(showFragment: ShowFragment)
    fun inject(showViewModel: ShowViewModel)
    fun inject(inputFragment: InputFragment)
    fun inject(resultFragment: ResultFragment)
}