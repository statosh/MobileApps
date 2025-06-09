package com.example.a09_06

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment

class SecondFragment: Fragment() {

    override fun onCreateView(i: LayoutInflater, c: ViewGroup?, s: Bundle?): View {
        val v = i.inflate(R.layout.fragment_second, c, false)
        val tv = v.findViewById<TextView>(R.id.textReceived)
        val args = arguments
        tv.text = "Получено:\n${args?.getString("a")}, ${args?.getString("b")}, ${args?.getString("c")}"
        return v
    }
}
