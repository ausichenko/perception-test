package com.ausichenko.test.perception.view.intro

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import com.ausichenko.test.perception.PerceptionApplication
import com.ausichenko.test.perception.R
import com.github.paolorotolo.appintro.AppIntro
import com.github.paolorotolo.appintro.AppIntroFragment
import com.github.paolorotolo.appintro.model.SliderPage
import com.google.firebase.analytics.FirebaseAnalytics
import javax.inject.Inject

class IntroActivity : AppIntro() {

    @Inject
    lateinit var firebaseAnalytics: FirebaseAnalytics

    private lateinit var introViewModel: IntroViewModel

    init {
        PerceptionApplication.appComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViewModel()
        initPages()
        firebaseAnalytics.setCurrentScreen(this, "intro", null)
    }

    private fun initViewModel() {
        introViewModel = ViewModelProviders.of(this).get(IntroViewModel::class.java)
    }

    private fun initPages() {
        val startPage = SliderPage()
        startPage.title = getString(R.string.tutorial_start_title)
        startPage.description = getString(R.string.tutorial_start_description)
        startPage.imageDrawable = R.drawable.start
        startPage.bgColor = ContextCompat.getColor(applicationContext, R.color.primary)
        addSlide(AppIntroFragment.newInstance(startPage))
        val showPage = SliderPage()
        showPage.title = getString(R.string.tutorial_show_title)
        showPage.description = getString(R.string.tutorial_show_description)
        showPage.imageDrawable = R.drawable.show
        showPage.bgColor = ContextCompat.getColor(applicationContext, R.color.primary)
        addSlide(AppIntroFragment.newInstance(showPage))
        val writePage = SliderPage()
        writePage.title = getString(R.string.tutorial_write_title)
        writePage.description = getString(R.string.tutorial_write_description)
        writePage.imageDrawable = R.drawable.write
        writePage.bgColor = ContextCompat.getColor(applicationContext, R.color.primary)
        addSlide(AppIntroFragment.newInstance(writePage))
        val resultPage = SliderPage()
        resultPage.title = getString(R.string.tutorial_result_title)
        resultPage.description = getString(R.string.tutorial_result_description)
        resultPage.imageDrawable = R.drawable.result
        resultPage.bgColor = ContextCompat.getColor(applicationContext, R.color.primary)
        addSlide(AppIntroFragment.newInstance(resultPage))
    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)

        introViewModel.setNonFirstStart()
        finish()
        firebaseAnalytics.logEvent("intro_skipped", null)
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)

        introViewModel.setNonFirstStart()
        finish()
        firebaseAnalytics.logEvent("intro_done", null)
    }
}