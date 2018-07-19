package com.ausichenko.test.perception

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showTutorial()
    }

    private fun showTutorial() {
        val preferences = getPreferences(Context.MODE_PRIVATE)
        if (preferences.getBoolean("is_first_start", true)) {
            startActivity(Intent(applicationContext, IntroActivity::class.java))
            //preferences.edit().putBoolean("is_first_start", false).apply()
        }
    }
}
