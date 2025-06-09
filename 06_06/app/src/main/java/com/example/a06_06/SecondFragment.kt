package com.example.a06_06

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class SecondFragment : Fragment() {
    private var initialX = 0f

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        val button: Button = view.findViewById(R.id.fragmentButton)

        button.setOnClickListener {
            view.setBackgroundColor(Color.BLUE)
        }

        button.setOnLongClickListener {
            view.setBackgroundColor(Color.parseColor("#800080")) // Фиолетовый
            true
        }

        view.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    initialX = event.x
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    val deltaX = event.x - initialX
                    if (Math.abs(deltaX) > 50) { // Порог для определения свайпа
                        v.setBackgroundColor(Color.parseColor("#FFC0CB")) // Розовый
                        true
                    } else {
                        false
                    }
                }
                else -> false
            }
        }

        return view
    }
}