package com.example.hackormyth

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {
    private val TAG = "QuizActivity"
    //Pulls the list of questions and answer from the QuizData object
    private val questions = QuizData.questions
    //Tracks the current question number and the user's score
    private var currentIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)//Links Kotlin file to XML layout (UI)
        Log.d(TAG, "onCreate: QuizActivity started")

        //Connects the variable to the UI component.
        val btnHack = findViewById<Button>(R.id.btnHack)
        val btnMyth = findViewById<Button>(R.id.btnMyth)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val quizView = findViewById<TextView>(R.id.quizView)
        val answerView = findViewById<TextView>(R.id.answerView)

        //Shows the question immediately
        loadQuestion(quizView, answerView)

        //The logic behind the Hack button
        btnHack.setOnClickListener {
            Log.d(TAG, "onClick: Hack button clicked")
            checkAnswer(true, answerView)
        }

        //The logic behind the Myth button
        btnMyth.setOnClickListener {
            Log.d(TAG, "onClick: Myth button clicked")
            checkAnswer(false, answerView)
        }

        //The logic behind the Next button
        btnNext.setOnClickListener {
            Log.d(TAG, "onClick:Next button clicked. Current index: $currentIndex")
            currentIndex++
            //Checks if there are more questions left
            if (currentIndex < questions.size) {
                loadQuestion(quizView, answerView)
            } else {
                //When quiz is complete, it navigates to theCScore screen and passes the data.
                Log.d(TAG, "onClick: Quiz finished. Final score: $score/$currentIndex")
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("Score", score)
                intent.putExtra("Total", questions.size)
                startActivity(intent)
                finish()//Closes the QuizActivity so that users can not go back to it.
            }
        }
    }

    // Helps to update the text on the screen for a new question
    private fun loadQuestion(questionView: TextView, feedbackView: TextView) {
        Log.d(TAG, "loadQuestion:Displaying question index $currentIndex")
        questionView.text = questions[currentIndex].statement
        feedbackView.text = ""//Clears previous feedback
    }

    //Checks to see if the user's click matches the correct answer.
    @SuppressLint("SetTextI18n")
    private fun checkAnswer(userAnswer: Boolean, feedbackView: TextView) {
        val correct = questions[currentIndex].isTrue == userAnswer
        Log.d(TAG, "checkAnswer:User selected $userAnswer. Correct answer was ${questions[currentIndex].isTrue}. Match: $correct")
        if (correct) {
            score++
            feedbackView.text = "Correct! You really know your stuff"
        }else{
            feedbackView.text = "Wrong! Try again next time"
        }
    }
}
