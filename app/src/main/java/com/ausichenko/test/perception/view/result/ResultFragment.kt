package com.ausichenko.test.perception.view.result

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.ausichenko.test.perception.PerceptionApplication
import com.ausichenko.test.perception.R
import com.google.firebase.analytics.FirebaseAnalytics
import kotlinx.android.synthetic.main.fragment_result.*
import javax.inject.Inject

class ResultFragment : Fragment() {

    @Inject lateinit var firebaseAnalytics: FirebaseAnalytics

    private var isSuccess: Boolean = false
    private var millis: Int = 0

    init {
        PerceptionApplication.appComponent.inject(this)
    }

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

        firebaseAnalytics.setCurrentScreen(activity!!, "result", null)
        val bundle = Bundle()
        bundle.putBoolean("is_success", isSuccess)
        if (isSuccess) bundle.putInt("time", millis)
        firebaseAnalytics.logEvent("result", bundle)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (isSuccess) {
            resultImage.setImageResource(R.drawable.ic_success)
            resultText.setText(R.string.success)
            resultText.setTextColor(ContextCompat.getColor(view.context, R.color.primary))

            timeText.visibility = View.VISIBLE
            timeText.text = getString(R.string.time_ms, millis)
        } else {
            resultImage.setImageResource(R.drawable.ic_fail)
            resultText.setText(R.string.fail)
            resultText.setTextColor(ContextCompat.getColor(view.context, R.color.fail))

            timeText.visibility = View.GONE
        }

        view.setOnClickListener {
            Navigation.findNavController(it).popBackStack(R.id.fragment_show, false)
        }
    }
}