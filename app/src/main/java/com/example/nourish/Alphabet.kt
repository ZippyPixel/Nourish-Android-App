package com.example.nourish

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class Alphabet : AppCompatActivity(), TextToSpeech.OnInitListener {

    private lateinit var backButton: ImageView
    private lateinit var nextButton: ImageView
    private lateinit var previousButton: ImageView
    private lateinit var speakButton: ImageView

    private lateinit var tvCapital: TextView
    private lateinit var tvSmall: TextView
    private lateinit var tvWord: TextView

    private var text: String = ""

    private  var currentCapital: Char = 'A'
    private  var currentSmall: Char = 'a'
    private var wordArray: Array<String> = arrayOf("Apple", "Ball", "Cat", "Dog", "Egg", "Fish", "Goat", "Hand", "Ink", "Jug", "Kite", "Lion", "Mango", "Nose", "Orange", "Plant", "Queen", "Rat", "Snake", "Tiger", "Umbrella", "Volcano", "Water", "Ox", "Yellow", "Zebra")

    private lateinit var tts: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alphabet)

        backButton = findViewById(R.id.backBtn)
        nextButton = findViewById(R.id.imageViewNext)
        speakButton = findViewById(R.id.imageViewSpeak)
        previousButton = findViewById(R.id.imageViewPrevious)

        tvCapital = findViewById(R.id.textViewCapital)
        tvSmall = findViewById(R.id.textViewSmall)
        tvWord = findViewById(R.id.textViewWord)

        tvCapital.text = currentCapital.toString()
        tvSmall.text = currentSmall.toString()

        speakButton.isEnabled = false
        tts = TextToSpeech(this, this)

        speakButton.setOnClickListener {
            speakOut(currentCapital.toString())
        }

        tvWord.setOnClickListener {
            speakOut(text)
        }

        visibilityCheck()

        nextButton.setOnClickListener {
            //visibilityCheck()
            if (currentCapital !='Z'){
                ++currentCapital
                ++currentSmall
                tvCapital.text = currentCapital.toString()
                tvSmall.text = currentSmall.toString()
            }
            visibilityCheck()
        }

        previousButton.setOnClickListener {
            //visibilityCheck()
            if (currentCapital !='A'){
                --currentCapital
                --currentSmall
                tvCapital.text = currentCapital.toString()
                tvSmall.text = currentSmall.toString()
            }
            visibilityCheck()
        }
        backButton.setOnClickListener{
            finish()
        }
    }

    private fun speakOut(text: String) {
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null,"")
    }

    override fun onInit(status: Int) {

        if (status == TextToSpeech.SUCCESS) {
            // set US English as language for tts
            val result = tts.setLanguage(Locale.US)

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
        wordUpdate()
        when (currentCapital) {
            'A' -> {
                previousButton.visibility = View.INVISIBLE
            }
            'Z' -> {
                nextButton.visibility = View.INVISIBLE
            }
            else -> {
                previousButton.visibility = View.VISIBLE
                nextButton.visibility = View.VISIBLE
            }
        }
    }

    private fun wordUpdate() {
        val wordIndex = currentCapital.code - 65
        text = "$currentCapital for ${wordArray[wordIndex]}"
        tvWord.text = text
    }
}