package com.example.nourish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Result : AppCompatActivity() {
    private lateinit var homeButton: ImageView
    private lateinit var repeatButton:ImageView
    private lateinit var tvScore: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        homeButton = findViewById(R.id.imageViewHome)
        repeatButton = findViewById(R.id.imageViewRepeat)
        tvScore = findViewById(R.id.textViewScore)

        val array: ArrayList<String> = intent.getStringArrayListExtra("result") as ArrayList<String>

        tvScore.text = array[0]


        homeButton.setOnClickListener {
//            val intent = Intent(this, Home::class.java)
//            startActivity(intent)
            finish()
        }

        repeatButton.setOnClickListener {
            val intent = Intent(this, Quiz::class.java)
            intent.putExtra("test",array[1])
            startActivity(intent)
            finish()
        }
    }
}