package com.example.nourish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Word : AppCompatActivity(), OnWordClickListener {

    private lateinit var backButton: ImageView
    private lateinit var recyclerView: RecyclerView

    private var titlesList = mutableListOf<String>()
    private var imagesList = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word)

        postToList()

        recyclerView = findViewById(R.id.recyclerView)
        backButton = findViewById(R.id.backBtn)

        recyclerView.layoutManager = LinearLayoutManager(this)

        var adapter = RecyclerAdapter(titlesList, imagesList, this)
        recyclerView.adapter = adapter

        //adapter.

        backButton.setOnClickListener(){
            finish()
        }
    }

    private fun addToList(title: String, image: Int){
        titlesList.add(title)
        imagesList.add(image)
    }

    private fun postToList(){
        addToList("Apple", R.drawable.apple)
        addToList("Ball", R.drawable.ball)
        addToList("Cat", R.drawable.cat)
        addToList("Dog", R.drawable.dog)
        addToList("Egg", R.drawable.egg)
        addToList("Fish", R.drawable.fish)
        addToList("Goat", R.drawable.goat)
        addToList("Hand", R.drawable.hand)
        addToList("Ink", R.drawable.ink)
        addToList("Jug", R.drawable.jug)
        addToList("Kite", R.drawable.kite)
        addToList("Lion", R.drawable.lion)
        addToList("Mango", R.drawable.mango)
        addToList("Nose", R.drawable.nose)
        addToList("Orange", R.drawable.orange)
        addToList("Plant", R.drawable.plant)
        addToList("Queen", R.drawable.queen)
        addToList("Rat", R.drawable.rat)
        addToList("Snake", R.drawable.snake)
        addToList("Tiger", R.drawable.tiger)
        addToList("Umbrella", R.drawable.umbrella)
        addToList("Volcano", R.drawable.volcano)
        addToList("Water", R.drawable.water)
        addToList("Ox", R.drawable.ox)
        addToList("Yellow", R.drawable.yellow)
        addToList("Zebra", R.drawable.zebra)
    }

    override fun onWordClickListener(position: Int) {
        val intent = Intent(this, WordDetail::class.java)
        intent.putExtra("wordPosition", position)
        startActivity(intent)
    }
}