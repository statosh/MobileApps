package com.example.a2504

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val editText = findViewById<EditText>(R.id.editText)
        val buttonThirdActivity = findViewById<Button>(R.id.buttonThirdActivity)

        buttonThirdActivity.setOnClickListener {
            val text = editText.text.toString()
            val intent = Intent(this, ThirdActivity::class.java)
            intent.putExtra("text", text)
            startActivity(intent)
        }
    }
}