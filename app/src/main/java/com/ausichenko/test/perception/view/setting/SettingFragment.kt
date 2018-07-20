package com.ausichenko.test.perception.view.setting

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.ausichenko.test.perception.R
import kotlinx.android.synthetic.main.fragment_setting.*

class SettingFragment : Fragment() {

    private var currentCount:Int = 0

    private lateinit var settingViewModel: SettingViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        initViewModel()
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }

    private fun initViewModel() {
        settingViewModel = ViewModelProviders.of(this).get(SettingViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        currentCount = settingViewModel.getNumberLength()
        countTextView.text = currentCount.toString()

        minusButton.setOnClickListener {
            if (currentCount > 1) currentCount--
            countTextView.text = currentCount.toString()
        }
        plusButton.setOnClickListener {
            if (currentCount < 6) currentCount++
            countTextView.text = currentCount.toString()
        }
        startButton.setOnClickListener {
            settingViewModel.saveNumberLength(currentCount)
            Navigation.findNavController(it).navigate(R.id.action_start)
        }
    }
}
