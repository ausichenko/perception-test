package com.ausichenko.test.perception

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation

class InputFragment : Fragment() {

    private var generated: String = ""
    private var millis: Int = 0

    private lateinit var inputText: TextView
    private lateinit var button0: TextView
    private lateinit var button1: TextView
    private lateinit var button2: TextView
    private lateinit var button3: TextView
    private lateinit var button4: TextView
    private lateinit var button5: TextView
    private lateinit var button6: TextView
    private lateinit var button7: TextView
    private lateinit var button8: TextView
    private lateinit var button9: TextView
    private lateinit var resetButton: ImageView
    private lateinit var doneButton: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_input, container, false)

        inputText = view.findViewById(R.id.input_text_view)
        button0 = view.findViewById(R.id.button_0)
        button1 = view.findViewById(R.id.button_1)
        button2 = view.findViewById(R.id.button_2)
        button3 = view.findViewById(R.id.button_3)
        button4 = view.findViewById(R.id.button_4)
        button5 = view.findViewById(R.id.button_5)
        button6 = view.findViewById(R.id.button_6)
        button7 = view.findViewById(R.id.button_7)
        button8 = view.findViewById(R.id.button_8)
        button9 = view.findViewById(R.id.button_9)
        resetButton = view.findViewById(R.id.reset_button)
        doneButton = view.findViewById(R.id.done_button)

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

        button0.setOnClickListener { inputText.append("0") }
        button1.setOnClickListener { inputText.append("1") }
        button2.setOnClickListener { inputText.append("2") }
        button3.setOnClickListener { inputText.append("3") }
        button4.setOnClickListener { inputText.append("4") }
        button5.setOnClickListener { inputText.append("5") }
        button6.setOnClickListener { inputText.append("6") }
        button7.setOnClickListener { inputText.append("7") }
        button8.setOnClickListener { inputText.append("8") }
        button9.setOnClickListener { inputText.append("9") }

        resetButton.setOnClickListener { inputText.text = "" }

        doneButton.setOnClickListener {
            val input = inputText.text.toString()
            if (generated.equals(input)) {
                val args = Bundle()
                args.putInt("millis", millis)
                Navigation.findNavController(it).navigate(R.id.action_success, args)
            } else {
                Navigation.findNavController(it).navigate(R.id.action_fail)
            }
        }
    }
}
