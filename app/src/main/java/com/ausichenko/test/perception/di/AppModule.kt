package com.ausichenko.test.perception.di

import android.content.Context
import com.ausichenko.test.perception.PerceptionApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val perceptionApplication: PerceptionApplication) {

    @Provides @Singleton fun provideContext(): Context = perceptionApplication
}