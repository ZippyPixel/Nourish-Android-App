package com.example.nourish

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class Number : AppCompatActivity(), TextToSpeech.OnInitListener {

    private lateinit var backButton: ImageView
    private lateinit var nextButton: ImageView
    private lateinit var previousButton: ImageView
    private lateinit var speakButton: ImageView

    private lateinit var tvDigit: TextView

    private lateinit var tts: TextToSpeech

    private var digit: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number)

        backButton = findViewById(R.id.backBtn)
        speakButton = findViewById(R.id.imageViewSpeak)
        nextButton = findViewById(R.id.imageViewNext)
        previousButton = findViewById(R.id.imageViewPrevious)

        tvDigit = findViewById(R.id.textViewDigit)

        speakButton.isEnabled = false;
        tts = TextToSpeech(this, this)

        speakButton.setOnClickListener {
            speakOut();
        }

        visibilityCheck()

        nextButton.setOnClickListener {
            if (digit != 100){
                ++digit
                tvDigit.text = digit.toString()
            }
            visibilityCheck()
        }

        previousButton.setOnClickListener {
            if (digit != 1){
                --digit
                tvDigit.text = digit.toString()
            }
            visibilityCheck()
        }

        backButton.setOnClickListener {
            finish()
        }
    }

    private fun speakOut(){
        val text = digit.toString()
        tts!!.speak(text, TextToSpeech.QUEUE_FLUSH, null,"")
    }

    override fun onInit(status: Int) {

        if (status == TextToSpeech.SUCCESS) {
            // set US English as language for tts
            val result = tts!!.setLanguage(Locale.US)

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS","The Language specified is not supported!")
            } else {
                speakButton.isEnabled = true
            }

        } else {
            Log.e("TTS", "Initialization Failed!")
        }

    }

    private fun visibilityCheck() {
        when (digit) {
            1 -> {
                previousButton.visibility = View.INVISIBLE
            }
            100 -> {
                nextButton.visibility = View.INVISIBLE
            }
            else -> {
                previousButton.visibility = View.VISIBLE
                nextButton.visibility = View.VISIBLE
            }
        }
    }

    public override fun onDestroy() {
        // Shutdown TTS
        if (tts != null) {
            tts!!.stop()
            tts!!.shutdown()
        }
        super.onDestroy()
    }
}