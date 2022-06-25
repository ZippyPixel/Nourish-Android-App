package com.example.nourish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var loginButton: Button
    private lateinit var signUpButton: TextView
    private lateinit var emailInput: EditText
    private lateinit var passwordInput: EditText

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()

        loginButton = findViewById(R.id.loginBtn)
        signUpButton = findViewById(R.id.signUpBtn)
        emailInput = findViewById(R.id.emailInput)
        passwordInput = findViewById(R.id.passwordInput)

        loginButton.setOnClickListener {
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()
            if(email !="" && password != ""){
                login(email, password)
            }
            else{
                Toast.makeText(this, "Please input email and password", Toast.LENGTH_SHORT).show()
            }
        }

        signUpButton.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
    }

    private fun login(email: String, password: String){
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // code for logging in user
                    val intent = Intent(this, Home::class.java)
                    finish()
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Wrong Email or Password", Toast.LENGTH_SHORT).show()
                }
            }
    }
    //if already logged in redirect to home
    override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        var currentUser = mAuth.getCurrentUser()

        if (currentUser != null){
            val intent = Intent(this, Home::class.java)
            finish()
            startActivity(intent)
        }
    }
}