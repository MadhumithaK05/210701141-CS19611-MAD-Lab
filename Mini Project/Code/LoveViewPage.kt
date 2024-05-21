package com.example.tunetwirlmadproject

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoveViewPage : AppCompatActivity() {
    private lateinit var mediaPlayers: Array<MediaPlayer>
    private lateinit var buttons: Array<Button>
    private val audioFiles = arrayOf(R.raw.jeans, R.raw.jeans, R.raw.jeans, R.raw.jeans, R.raw.jeans, R.raw.jeans, R.raw.jeans, R.raw.jeans, R.raw.jeans, R.raw.jeans, R.raw.jeans, R.raw.jeans)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_love_view_page)

        mediaPlayers = Array(12) { MediaPlayer.create(this, audioFiles[it]) }
        buttons = Array(12) { findViewById<Button>(resources.getIdentifier("bt${it+1}", "id", packageName)) }

        buttons.forEachIndexed { index, button ->
            button.setOnClickListener {
                handleButtonClick(index)
            }
        }
    }
    private fun handleButtonClick(index: Int) {
        val mediaPlayer = mediaPlayers[index]
        val button = buttons[index]

        if (!mediaPlayer.isPlaying) {
            mediaPlayer.start()
            button.text = "pause"
        } else {
            mediaPlayer.pause()
            button.text = "play"
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayers.forEach { it.release() } // Release MediaPlayer when the activity is destroyed
    }
}