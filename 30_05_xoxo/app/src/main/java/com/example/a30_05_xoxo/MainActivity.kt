package com.example.a30_05_xoxo

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.a30_05_xoxo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var currentPlayer = "X"
    private val board = Array(3) { arrayOfNulls<String>(3) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttons = listOf(
            listOf(binding.a1, binding.a2, binding.a3),
            listOf(binding.b1, binding.b2, binding.b3),
            listOf(binding.c1, binding.c2, binding.c3)
        )

        for (i in 0..2) {
            for (j in 0..2) {
                buttons[i][j].setOnClickListener {
                    if (buttons[i][j].text.isEmpty()) {
                        buttons[i][j].text = currentPlayer
                        board[i][j] = currentPlayer
                        if (checkWin()) {
                            Toast.makeText(this, "Игрок $currentPlayer победил!", Toast.LENGTH_LONG).show()
                            resetBoard(buttons)
                        } else {
                            currentPlayer = if (currentPlayer == "X") "O" else "X"
                        }
                    }
                    binding.currentPlayerText.text = "Ход: $currentPlayer"
                }
            }
        }

        binding.resetButton.setOnClickListener {
            resetBoard(buttons)
        }
        binding.currentPlayerText.text = "Ход: $currentPlayer"
    }

    private fun checkWin(): Boolean {
        for (i in 0..2) {
            if (board[i][0] != null && board[i][0] == board[i][1] && board[i][1] == board[i][2]) return true
            if (board[0][i] != null && board[0][i] == board[1][i] && board[1][i] == board[2][i]) return true
        }
        if (board[0][0] != null && board[0][0] == board[1][1] && board[1][1] == board[2][2]) return true
        if (board[0][2] != null && board[0][2] == board[1][1] && board[1][1] == board[2][0]) return true
        return false
    }

    private fun resetBoard(buttons: List<List<Button>>) {
        for (i in 0..2) {
            for (j in 0..2) {
                board[i][j] = null
                buttons[i][j].text = ""
            }
        }
        currentPlayer = "X"
        binding.currentPlayerText.text = "Ход: $currentPlayer"
    }
}
