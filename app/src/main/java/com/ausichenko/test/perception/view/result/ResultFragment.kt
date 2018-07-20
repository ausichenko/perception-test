package com.ausichenko.test.perception.view.result

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import com.ausichenko.test.perception.R

class ResultFragment : Fragment() {

    private var isSuccess: Boolean = false
    private var millis: Int = 0

    private lateinit var resultIcon: ImageView
    private lateinit var resultText: TextView
    private lateinit var timeText: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_result, container, false)

        isSuccess = arguments?.let {
            val safeArgs = ResultFragmentArgs.fromBundle(it)
            safeArgs.isSuccess
        }!!
        millis = arguments?.let {
            val safeArgs = ResultFragmentArgs.fromBundle(it)
            safeArgs.millis
        }!!

        resultIcon = view.findViewById(R.id.result_image)
        resultText = view.findViewById(R.id.result_text)
        timeText = view.findViewById(R.id.time_text_view)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (isSuccess) {
            resultIcon.setImageResource(R.drawable.ic_success)
            resultText.setText(R.string.success)
            resultText.setTextColor(ContextCompat.getColor(view.context, R.color.primary))

            timeText.visibility = View.VISIBLE
            timeText.text = getString(R.string.time_ms, millis)
        } else {
            resultIcon.setImageResource(R.drawable.ic_fail)
            resultText.setText(R.string.fail)
            resultText.setTextColor(ContextCompat.getColor(view.context, R.color.fail))

            timeText.visibility = View.GONE
        }

        view.setOnClickListener {
            Navigation.findNavController(it).popBackStack(R.id.fragment_show, false)
        }
    }
}