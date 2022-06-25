package com.example.nourish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUp : AppCompatActivity(){

    private lateinit var backButton: ImageView
    private lateinit var createAccountButton: Button

    private lateinit var parentNameInput: EditText
    private lateinit var emailInput: EditText
    private lateinit var password: EditText
    private lateinit var confirmPassword: EditText
    private lateinit var childName: EditText

    private lateinit var warning: TextView
    private lateinit var matchPassword: TextView

    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDbRef: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        mAuth = FirebaseAuth.getInstance()

        backButton = findViewById(R.id.backBtn)
        createAccountButton = findViewById(R.id.createAccountBtn)

        parentNameInput = findViewById(R.id.editTextParentsName)
        emailInput = findViewById(R.id.editTextParentsEmail)
        password = findViewById(R.id.editTextPassword)
        confirmPassword = findViewById(R.id.editTextConfirmPassword)
        childName = findViewById(R.id.editTextChildName)

        warning = findViewById(R.id.textViewWarning)
        matchPassword = findViewById(R.id.textViewMatchPassword)

        backButton.setOnClickListener(){
            finish()
        }

        createAccountButton.setOnClickListener {
            val pName = parentNameInput.text.toString()
            val cName = childName.text.toString()
            val email = emailInput.text.toString()
            val password = password.text.toString()
            val cPassword = confirmPassword.text.toString()

            // creating new user account
            if (checkEntries(pName, email, password, cName, cPassword)){
                signUp(pName, cName, email, password)
            }
        }
    }

    // checking entries if they are valid or not
    private fun checkEntries(pName: String, email: String, password: String, cName: String, cPassword: String): Boolean {
        if (pName != "" && email != "" && password != "" && cName != "" && cPassword != ""){
            warning.text = ""
            return if (password == cPassword) {
                true
            }
            else{
                matchPassword.text = "Passwords do not match"
                false
            }
        }
        else{
            if (password == cPassword) {
                matchPassword.text = ""
            }
            else{
                matchPassword.text = "Passwords do not match"
            }
            warning.text = "Please fill up all entries"

            return false
        }
    }

    // adding user authentication
    private fun signUp(pName: String, cName: String, email: String, password: String) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    //add user info to the firebase
                    addUserToDatabase(pName, cName, email, mAuth.currentUser?.uid!!)
                    // code for jumping to HOME
                    val intent = Intent(this, Home::class.java)
                    finish()
                    startActivity(intent)
                } else {
                    // in case sign up is unsuccessful
                    Toast.makeText(this, "Some error occurred", Toast.LENGTH_SHORT).show()
                }
        }
    }

    // adding new user info to firebase
    private fun addUserToDatabase(pName: String, cName: String, email: String, uid: String) {
        mDbRef = FirebaseDatabase.getInstance().getReference()
        mDbRef.child("user").child(uid).setValue(User(pName, cName, email))
    }
}