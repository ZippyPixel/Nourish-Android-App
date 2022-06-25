package com.example.nourish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class Home : AppCompatActivity() {

    private lateinit var displayName: TextView

    private lateinit var testButton: Button
    private lateinit var logOutButton: ImageView

    private lateinit var alphabetsButton: Button
    private lateinit var numbersButton: Button
    private lateinit var wordsButton: Button
    private lateinit var wordGuessButton: Button
    private lateinit var blankFillButton: Button
    private lateinit var countButton: Button

    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDbRef: DatabaseReference

    private lateinit var cName: String
    private lateinit var pName: String
    private lateinit var email: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        mAuth = FirebaseAuth.getInstance()

        displayName = findViewById(R.id.textViewDisplayName)
        logOutButton = findViewById(R.id.imageViewLogoutBtn)
        testButton = findViewById(R.id.testBtn)
        alphabetsButton = findViewById(R.id.alphabetsBtn)
        numbersButton = findViewById(R.id.numbersBtn)
        wordsButton = findViewById(R.id.wordsBtn)
        wordGuessButton = findViewById(R.id.wordGuessBtn)
        blankFillButton = findViewById(R.id.blankFillBtn)
        countButton = findViewById(R.id.countBtn)

        getUserInfo(mAuth.currentUser?.uid!!)

        alphabetsButton.setOnClickListener {
            val intent = Intent(this, Alphabet::class.java)
            startActivity(intent)
        }

        numbersButton.setOnClickListener {
            val intent = Intent(this, Number::class.java)
            startActivity(intent)
        }

        wordsButton.setOnClickListener {
            val intent = Intent(this, Word::class.java)
            startActivity(intent)
        }

        wordGuessButton.setOnClickListener {
            val intent = Intent(this, Quiz::class.java)
            intent.putExtra("test","WordGuess")
            startActivity(intent)
        }

        blankFillButton.setOnClickListener {
            val intent = Intent(this, Quiz::class.java)
            intent.putExtra("test","BlankFill")
            startActivity(intent)
        }

        countButton.setOnClickListener {
            val intent = Intent(this, Quiz::class.java)
            intent.putExtra("test","Count")
            startActivity(intent)
        }

        testButton.setOnClickListener {
            val intent = Intent(this, Quiz::class.java)
            intent.putExtra("test","Test")
            startActivity(intent)
        }

        logOutButton.setOnClickListener {
            mAuth.signOut()
            finish()
        }

    }

    private fun getUserInfo(uid: String) {
        mDbRef = FirebaseDatabase.getInstance().getReference("user")

        mDbRef.child(uid).get().addOnSuccessListener {
            if (it.exists()){
                cName = it.child("cname").value.toString()
                pName = it.child("pname").value.toString()
                email = it.child("email").value.toString()
                displayName.text = cName
                Toast.makeText(this, "Successfully retrieved", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "Users does not exist", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener{
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
        }
    }
}
