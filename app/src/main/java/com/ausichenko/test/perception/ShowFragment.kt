package com.ausichenko.test.perception

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import android.widget.TextView
import androidx.navigation.Navigation
import java.text.DecimalFormat
import java.util.*

class ShowFragment : Fragment() {

    private var count: Int = 2
    private var downMillis: Long = 0
    private var upMillis: Long = 0
    private var generate: String = ""

    private lateinit var showText: TextView
    private lateinit var showButton: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_show, container, false)

        showText = view.findViewById(R.id.show_text_view)
        showButton = view.findViewById(R.id.show_button)

        count = arguments.let {
            val safeArgs = ShowFragmentArgs.fromBundle(it)
            safeArgs.count
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showButton.setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                generate()

                downMillis = System.currentTimeMillis()
                showText.text = generate
            }
            if (event.action == MotionEvent.ACTION_UP) {
                upMillis = System.currentTimeMillis()
                showText.text = ""

                val args = Bundle()
                args.putString("generated", generate)
                args.putInt("millis", (upMillis - downMillis).toInt())
                Navigation.findNavController(v).navigate(R.id.action_input, args)
            }
            true
        }
    }

    private fun generate() {
        var pattern = ""
        for (it in 1..count) {
            pattern += "0"
        }
        val decimalFormat = DecimalFormat(pattern)
        val randomNumber = Random().nextInt(Math.pow(10.0, count.toDouble()).toInt())

        generate = decimalFormat.format(randomNumber)
        showText.text = generate
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.fragment_show, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.setting -> {
                view?.let { Navigation.findNavController(it).popBackStack(R.id.fragment_setting, false) }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
