package com.example.a21_05_lab

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.Toast

class DragActivity : AppCompatActivity() {
    private lateinit var mediaPlayerTouch: MediaPlayer
    private var originalImageRes: Int = 0
    private var activeView: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drag)

        mediaPlayerTouch = MediaPlayer.create(this, R.raw.touch_sound)

        val imageViews = listOf(
            findViewById<ImageView>(R.id.imageView1),
            findViewById<ImageView>(R.id.imageView2),
            findViewById<ImageView>(R.id.imageView3),
            findViewById<ImageView>(R.id.imageView4)
        )

        imageViews.forEach { imageView ->
            imageView.setOnTouchListener { v, event ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        activeView = imageView
                        originalImageRes = (imageView.drawable.constantState?.newDrawable()?.constantState)?.hashCode() ?: 0
                        imageView.setColorFilter(resources.getColor(android.R.color.holo_blue_light))
                        mediaPlayerTouch.start()
                        true
                    }
                    MotionEvent.ACTION_MOVE -> {
                        imageView.x = event.rawX - imageView.width / 2
                        imageView.y = event.rawY - imageView.height / 2
                        true
                    }
                    MotionEvent.ACTION_UP -> {
                        imageView.clearColorFilter()
                        Toast.makeText(this, "Вы отпустили картинку", Toast.LENGTH_SHORT).show()
                        activeView = null
                        true
                    }
                    else -> false
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayerTouch.release()
    }
}