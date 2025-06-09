package com.example.a06_06

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment

class FirstFragment : Fragment() {
    private lateinit var image1: ImageView
    private lateinit var image2: ImageView
    private lateinit var image3: ImageView
    private lateinit var changeButton: Button
    private lateinit var mediaPlayer: MediaPlayer

    private val imageResources = listOf(
        R.drawable.img,
        R.drawable.img1,
        R.drawable.img2
    )
    private var currentIndex = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        image1 = view.findViewById(R.id.image1)
        image2 = view.findViewById(R.id.image2)
        image3 = view.findViewById(R.id.image3)
        changeButton = view.findViewById(R.id.changeButton)
        mediaPlayer = MediaPlayer.create(context, R.raw.sound)

        updateImages()

        changeButton.setOnClickListener {
            mediaPlayer.start()
            currentIndex = (currentIndex + 1) % imageResources.size
            updateImages()
        }

        return view
    }

    private fun updateImages() {
        image1.setImageResource(imageResources[currentIndex % imageResources.size])
        image2.setImageResource(imageResources[(currentIndex + 1) % imageResources.size])
        image3.setImageResource(imageResources[(currentIndex + 2) % imageResources.size])
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}