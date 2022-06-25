package com.example.nourish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class Quiz : AppCompatActivity() {

    private lateinit var backButton: ImageView
    private lateinit var nextButton: ImageView
    private lateinit var itemImage: ImageView

    private lateinit var option1: TextView
    private lateinit var option2: TextView
    private lateinit var option3: TextView
    private lateinit var option4: TextView

    private lateinit var tvProgress: TextView
    private lateinit var tvScore: TextView

    private lateinit var tvQuestion: TextView

    private var selected: Boolean = false
    private var currentPosition: Int = 1
    private var position: Int = 0
    private var range: Int = 0
    private var score = 0
    private var answer: String = ""

    private var questionList: ArrayList<Question>? = null

    private var doneQuestionsList= mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        backButton = findViewById(R.id.backBtn)
        itemImage = findViewById(R.id.imageViewItem)
        nextButton = findViewById(R.id.imageViewNextButton)

        option1 = findViewById(R.id.textViewOption1)
        option2 = findViewById(R.id.textViewOption2)
        option3 = findViewById(R.id.textViewOption3)
        option4 = findViewById(R.id.textViewOption4)

        tvProgress = findViewById(R.id.textViewProgress)
        tvScore = findViewById(R.id.textViewScore)

        tvQuestion = findViewById(R.id.textViewQuestion)

        val questionType = intent.getStringExtra("test")

        when (questionType) {
            "WordGuess" -> {
                questionList = QuestionBank.wordGuessQuestions()
            }
            "BlankFill" -> {
                questionList = QuestionBank.blankFillQuestions()
            }
            "Count" -> {
                questionList = QuestionBank.countQuestions()
            }
            else -> {
                questionList = QuestionBank.blankFillQuestions()
                questionList!! += QuestionBank.wordGuessQuestions()
                questionList!! += QuestionBank.countQuestions()
            }
        }
        range = questionList!!.size - 1
        position = (0..range).random()

        updateInfo()
        setQuestion()

        optionSelected()

        nextButton.setOnClickListener {
            if (currentPosition == 10 && selected) {
                var array: ArrayList<String> = ArrayList()
                array.add("$score")
                array.add(questionType!!)
                val intent = Intent(this, Result::class.java)
                intent.putExtra("result", array)
                startActivity(intent)
                finish()
            }
            if (currentPosition < 10) {
                if (selected) {
                    ++currentPosition
                    setQuestion()
                    updateInfo()
                    selected = false
                } else {
                    Toast.makeText(this, "No option is selected", Toast.LENGTH_SHORT).show()
                }
            }
        }

        backButton.setOnClickListener {
            finish()
        }
    }

    private fun optionSelected() {

            option1.setOnClickListener {
                checkAnswer(option1)
                selected = true
            }
            option2.setOnClickListener {
                checkAnswer(option2)
                selected = true
            }
            option3.setOnClickListener {
                checkAnswer(option3)
                selected = true
            }
            option4.setOnClickListener {
                checkAnswer(option4)
                selected = true
            }

    }

    private fun defaultOptionView(){
        val options = ArrayList<TextView>()
        options.add(option1)
        options.add(option2)
        options.add(option3)
        options.add(option4)

        for (option in options){
            option.setBackgroundResource(R.drawable.input_field)
        }

    }


    private fun updateInfo() {
        tvProgress.text = "$currentPosition/10"
        tvScore.text = "Score:$score"
    }

    private fun setQuestion(){
        defaultOptionView()

        val question: Question = questionList!![position]

        doneQuestionsList.add(position)

        tvQuestion.text = question.question
        itemImage.setImageResource(question.image)
        option1.text = question.option1
        option2.text = question.option2
        option3.text = question.option3
        option4.text = question.option4
        answer = question.correctAnswer

        while (true){
            position = (0..range).random()
            var doesNotMatch = true
            for (number in doneQuestionsList){
                if (number == position){
                    doesNotMatch = false
                }
            }
            if (doesNotMatch){
                break
            }
        }
    }

    private fun checkAnswer(option: TextView?) {
        if (!selected){
            if (option?.text.toString() == answer){
                option?.setBackgroundResource(R.drawable.right_answer)
                ++score
                tvScore.text = "Score:$score"
            }
            else{
                option?.setBackgroundResource(R.drawable.wrong_answer)
            }
            val options = ArrayList<TextView>()
            options.add(option1)
            options.add(option2)
            options.add(option3)
            options.add(option4)

            for (option in options){
                if(option.text.toString() == answer) {
                    option.setBackgroundResource(R.drawable.right_answer)
                }
            }
        }
    }
}