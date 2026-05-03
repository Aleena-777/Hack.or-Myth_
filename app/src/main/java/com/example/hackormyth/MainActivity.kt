package com.example.hackormyth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    //TAG used for Logging to show where gthe logs come from
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)//Links Kotlin file to the XML layout (UI)
        Log.d(TAG, "onCreate: MainActivity started")

        //Connects the variable to the UI component.
        val btnStart = findViewById<Button>(R.id.btnStart)
        btnStart.setOnClickListener {
            //  Intent is used to open another activity.
            Log.d(TAG, "onClick: start Button clicked, navigating o QuizActivity")
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)


        }
    }
}