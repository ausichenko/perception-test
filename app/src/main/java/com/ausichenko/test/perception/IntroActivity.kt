package com.ausichenko.test.perception

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import com.github.paolorotolo.appintro.AppIntro
import com.github.paolorotolo.appintro.AppIntroFragment
import com.github.paolorotolo.appintro.model.SliderPage


class IntroActivity : AppIntro() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sliderPageChoose = SliderPage()
        sliderPageChoose.title = "Choose length"
        sliderPageChoose.description = "Choose length of number and tap on Start button"
        sliderPageChoose.imageDrawable = R.drawable.start
        sliderPageChoose.bgColor = ContextCompat.getColor(applicationContext, R.color.primary)
        addSlide(AppIntroFragment.newInstance(sliderPageChoose))
        val sliderPageShow = SliderPage()
        sliderPageShow.title = "Tap to show"
        sliderPageShow.description = "Tap and hold to show a number"
        sliderPageShow.imageDrawable = R.drawable.show
        sliderPageShow.bgColor = ContextCompat.getColor(applicationContext, R.color.primary)
        addSlide(AppIntroFragment.newInstance(sliderPageShow))
        val sliderPageWrite = SliderPage()
        sliderPageWrite.title = "Write a number"
        sliderPageWrite.description = "Write and check your result"
        sliderPageWrite.imageDrawable = R.drawable.write
        sliderPageWrite.bgColor = ContextCompat.getColor(applicationContext, R.color.primary)
        addSlide(AppIntroFragment.newInstance(sliderPageWrite))
        val sliderPageResult = SliderPage()
        sliderPageResult.title = "Good luck"
        sliderPageResult.description = "Improve your perception"
        sliderPageResult.imageDrawable = R.drawable.result
        sliderPageResult.bgColor = ContextCompat.getColor(applicationContext, R.color.primary)
        addSlide(AppIntroFragment.newInstance(sliderPageResult))
    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        finish()
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        finish()
    }
}