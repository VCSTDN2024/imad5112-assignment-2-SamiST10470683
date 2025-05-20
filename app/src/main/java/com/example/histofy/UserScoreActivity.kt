package com.example.histofy
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class UserScoreActivity : AppCompatActivity() {

    // Declare UI Elements.
    private lateinit var scoreTextView: TextView
    private lateinit var reviewBtn: Button
    private lateinit var retryBtn: Button
    private lateinit var feedbackTextView: TextView
    private lateinit var exitBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_score)

        // Initialise UI Elements.
        scoreTextView = findViewById(R.id.scoreTextView)
        feedbackTextView = findViewById(R.id.feedbackTextView)
        retryBtn = findViewById(R.id.retryBtn)
        exitBtn = findViewById(R.id.exitBtn)

        //Set up animated background.
        val constraintLayout = findViewById<ConstraintLayout>(R.id.constraintLayout)
        val animationDrawable = constraintLayout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration (1000) // Fade-in animation duration.
        animationDrawable.setExitFadeDuration(2000)  // Fade-out animation duration.
        animationDrawable.start()

        // Get score and total number of questions from intent extras.
        val score = intent.getIntExtra("Score:", 0)
        val total = intent.getIntExtra("Total:", 0)

        // Display user's score.
        scoreTextView.text = "You scored $score out of $total."

        // Show feedback based on the score.
        feedbackTextView.text = if (score >= 3) {
            "Great job! You know your history!"
        } else {
            "It's okay! Keep practising!"
        }

        // Set onClick listener for the Retry button.
        // Restart the quiz. (go back to previous screen)
        retryBtn.setOnClickListener {
            finish()
        }

        // Set onClick listener for the Exit button.
        // When clicked, it finishes (closes) the entire app.
        exitBtn.setOnClickListener {
            finishAffinity()
        }
    }
}
