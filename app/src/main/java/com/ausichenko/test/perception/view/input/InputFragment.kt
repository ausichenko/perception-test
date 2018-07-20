package com.ausichenko.test.perception.view.input

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import com.ausichenko.test.perception.R
import kotlinx.android.synthetic.main.fragment_input.*

class InputFragment : Fragment() {

    private val isSuccessArg = "isSuccess"
    private val millisArg = "millis"

    private var generated: String = ""
    private var millis: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_input, container, false)

        generated = arguments?.let {
            val safeArgs = InputFragmentArgs.fromBundle(it)
            safeArgs.generated
        }!!
        millis = arguments?.let {
            val safeArgs = InputFragmentArgs.fromBundle(it)
            safeArgs.millis
        }!!

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button0.setOnClickListener { inputTextView.append("0") }
        button1.setOnClickListener { inputTextView.append("1") }
        button2.setOnClickListener { inputTextView.append("2") }
        button3.setOnClickListener { inputTextView.append("3") }
        button4.setOnClickListener { inputTextView.append("4") }
        button5.setOnClickListener { inputTextView.append("5") }
        button6.setOnClickListener { inputTextView.append("6") }
        button7.setOnClickListener { inputTextView.append("7") }
        button8.setOnClickListener { inputTextView.append("8") }
        button9.setOnClickListener { inputTextView.append("9") }

        resetButton.setOnClickListener { inputTextView.text = "" }
        doneButton.setOnClickListener {
            val input = inputTextView.text.toString()
            val args = Bundle()
            args.putBoolean(isSuccessArg, TextUtils.equals(generated, input))
            args.putInt(millisArg, millis)
            Navigation.findNavController(it).navigate(R.id.action_result, args)
        }
    }
}
