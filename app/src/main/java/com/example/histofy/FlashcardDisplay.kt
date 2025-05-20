package com.example.histofy

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class FlashcardDisplay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flashcard_display)

        // Initialise UI Elements.
        val EgyptQuizBtn: Button = findViewById(R.id.EgyptQuizBtn)
        val GreeceQuizBtn: Button = findViewById(R.id.GreeceQuizBtn)
        val RomeQuizBtn: Button = findViewById(R.id.RomeQuizBtn)
        val exitBtn: Button = findViewById(R.id.exitBtn)

        // Set onClick listener for the Ancient Egypt button.
        // Navigate to Egypt Quiz page.
        EgyptQuizBtn.setOnClickListener {
            startActivity(Intent(this, EgyptQuizActivity::class.java))
        }

        // Set onClick listener for the Ancient Greece button.
        // Navigate to Greece Quiz page.
        GreeceQuizBtn.setOnClickListener {
            startActivity(Intent(this, GreeceQuizActivity::class.java))
        }

        // Set onClick listener for the Ancient Rome button.
        // Navigate to Rome Quiz page.
        RomeQuizBtn.setOnClickListener {
            startActivity(Intent(this, RomeQuizActivity::class.java))
        }

        // Set onClick listener for the Back button.
        // When clicked, it finishes (closes) the current activity and goes back to the previous page.
        exitBtn.setOnClickListener {
            finish()
        }

        // Set up animated background.
        val constraintLayout = findViewById<ConstraintLayout>(R.id.constraintLayout)
        val animationDrawable = constraintLayout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(1000) // Fade-in duration.
        animationDrawable.setExitFadeDuration(2000) // Fade-out duration.
        animationDrawable.start()

    }
}
