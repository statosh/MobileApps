package com.example.a09_06

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class FirstFragment: Fragment() {

    companion object {
        private const val ARG_LABEL = "argLabel"
        fun newInstance(label: String) = FirstFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_LABEL, label)
            }
        }
    }

    private lateinit var tvState: TextView
    private lateinit var e1: EditText
    private lateinit var e2: EditText
    private lateinit var e3: EditText
    private lateinit var btnSend: Button

    override fun onCreateView(i: LayoutInflater, c: ViewGroup?, s: Bundle?): View {
        val v = i.inflate(R.layout.fragment_first, c, false)
        tvState = v.findViewById(R.id.textState)
        e1 = v.findViewById(R.id.et1)
        e2 = v.findViewById(R.id.et2)
        e3 = v.findViewById(R.id.et3)
        btnSend = v.findViewById(R.id.btnSendToSecondFragment)

        val label = arguments?.getString(ARG_LABEL)
        tvState.text = "Первый фрагмент. Перешли из: ${label ?: ""}"

        btnSend.setOnClickListener {
            val a = e1.text.toString().trim()
            val b = e2.text.toString().trim()
            @Suppress("NAME_SHADOWING") val c = e3.text.toString().trim()
            if (a.isEmpty() || b.isEmpty() || c.isEmpty()) {
                Toast.makeText(requireContext(), "Заполните все поля", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val bundle = Bundle().apply {
                putString("a", a)
                putString("b", b)
                putString("c", c)
            }
            parentFragmentManager.beginTransaction()
                .replace(R.id.primaryFragmentContainer, SecondFragment().apply { arguments = bundle })
                .addToBackStack(null)
                .commit()
        }
        return v
    }
}
