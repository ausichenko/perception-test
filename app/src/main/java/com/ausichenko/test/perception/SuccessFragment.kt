package com.ausichenko.test.perception

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation

class SuccessFragment : Fragment() {

    private var millis: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_success, container, false)

        millis = arguments?.let {
            val safeArgs = InputFragmentArgs.fromBundle(it)
            safeArgs.millis
        }!!

        view.findViewById<TextView>(R.id.time_text_view).text = millis.toString().plus(" ms")

        view.setOnClickListener {
            Navigation.findNavController(it).popBackStack(R.id.fragment_show, false)
        }

        return view
    }
}
