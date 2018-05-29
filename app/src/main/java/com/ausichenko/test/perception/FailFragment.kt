package com.ausichenko.test.perception

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation

class FailFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_fail, container, false)

        view.setOnClickListener {
            Navigation.findNavController(it).popBackStack(R.id.fragment_show, false)
        }

        return view
    }
}
