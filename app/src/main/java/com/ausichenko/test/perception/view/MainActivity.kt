package com.ausichenko.test.perception.view

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ausichenko.test.perception.view.intro.IntroActivity
import com.ausichenko.test.perception.R

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        showTutorial()
    }

    private fun initViewModel() {
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    private fun showTutorial() {
        if (mainViewModel.isFirstStart()) {
            startActivity(Intent(applicationContext, IntroActivity::class.java))
        }
    }
}
