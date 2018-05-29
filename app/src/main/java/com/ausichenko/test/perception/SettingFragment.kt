package com.ausichenko.test.perception

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.Navigation

class SettingFragment : Fragment() {

    private var currentCount:Int = 3

    private lateinit var minusButton: ImageView
    private lateinit var plusButton: ImageView
    private lateinit var countText: TextView
    private lateinit var startButton: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_setting, container, false)

        minusButton = view.findViewById(R.id.minus_button)
        plusButton = view.findViewById(R.id.plus_button)
        countText = view.findViewById(R.id.count_text_view)
        startButton = view.findViewById(R.id.start_button)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        countText.text = currentCount.toString()

        minusButton.setOnClickListener {
            if (currentCount > 1) currentCount--
            countText.text = currentCount.toString()
        }
        plusButton.setOnClickListener {
            if (currentCount < 6) currentCount++
            countText.text = currentCount.toString()
        }
        startButton.setOnClickListener {
            val args = Bundle()
            args.putInt("count", currentCount)
            Navigation.findNavController(it).navigate(R.id.action_start, args)
        }
    }
}
