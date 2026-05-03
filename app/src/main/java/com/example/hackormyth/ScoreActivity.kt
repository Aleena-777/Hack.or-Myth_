package com.example.hackormyth

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {
    private val TAG = "ScoreActivity"

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)//Links Kotlin file to XML layout (UI)
        Log.d(TAG, "onCreate: ScoreActivity started")

        // Get the score and total passed from the QuizActivity.
        val score = intent.getIntExtra("Score", 0)
        val total = intent.getIntExtra("Total", 0)
        Log.d(TAG, "onCreate: Received score: $score, total: $total")

        //Connect the variable to UI component.
        val scoreView = findViewById<TextView>(R.id.scoreView)
        val feedbackView = findViewById<TextView>(R.id.feedbackView)

        //Displays the final score.
        scoreView.text = "You scored $score out of $total"

        //Provides feedback based on how well the user did.
        feedbackView.text = if (score > total / 2) {
            "Master Hacker"
        } else {
            "Stay Safe Online"
        }

        //Connect the variable to UI component.
        val btnReview = findViewById<Button>(R.id.btnReview)
        btnReview.setOnClickListener {
            Log.d(TAG, "onClick: Review button clicked")
            showReview() 
        }
    }
    //Shows the review when user's click the Review button
    @SuppressLint("SetTextI18n")
    private fun showReview() {
        Log.d(TAG, "showReview: Building review text")
        //Connect the variable to UI component.
        val reviewView = findViewById<TextView>(R.id.reviewView)
        
        // This builds the review text by joining all questions and explanations
        val reviewText = QuizData.questions.joinToString(separator = "\n\n") { question ->
            "Question: ${question.statement}\n Fact: ${question.explanation}"
        }
        
        reviewView.text = reviewText
    }
}
