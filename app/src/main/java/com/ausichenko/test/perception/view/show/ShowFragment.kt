package com.ausichenko.test.perception.view.show

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import androidx.navigation.Navigation
import com.ausichenko.test.perception.R
import kotlinx.android.synthetic.main.fragment_show.*
import java.text.DecimalFormat
import java.util.*

class ShowFragment : Fragment() {

    private val generatedArg = "generated"
    private val millisArg = "millis"

    private var downMillis: Long = 0
    private var upMillis: Long = 0
    private var generate: String = ""

    private lateinit var showViewModel: ShowViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_show, container, false)

        initViewModel()

        return view
    }

    private fun initViewModel() {
        showViewModel = ViewModelProviders.of(this).get(ShowViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showButton.setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                generate()

                downMillis = System.currentTimeMillis()
                showTextView.text = generate
            }
            if (event.action == MotionEvent.ACTION_UP) {
                upMillis = System.currentTimeMillis()
                showTextView.text = ""

                val args = Bundle()
                args.putString(generatedArg, generate)
                args.putInt(millisArg, (upMillis - downMillis).toInt())
                Navigation.findNavController(v).navigate(R.id.action_input, args)
            }
            true
        }
    }

    private fun generate() {
        val numberLength = showViewModel.getNumberLength()
        var pattern = ""
        for (it in 1..numberLength) {
            pattern += "0"
        }
        val decimalFormat = DecimalFormat(pattern)
        val randomNumber = Random().nextInt(Math.pow(10.0, numberLength.toDouble()).toInt())

        generate = decimalFormat.format(randomNumber)
        showTextView.text = generate
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
