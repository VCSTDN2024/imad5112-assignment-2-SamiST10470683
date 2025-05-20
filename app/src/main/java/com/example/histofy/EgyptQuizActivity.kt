package com.example.histofy
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class EgyptQuizActivity : AppCompatActivity() {
    // Array of quiz questions.
    private val questions = arrayOf(
        "1. The Nile River flows from the south to the north.",
        "2. The Ancient Egyptians believed in several Gods and Goddesses.",
        "3. The pyramids were built as homes for the Gods.",
        "4. Hieroglyphics was the writing system of the Ancient Egyptians.",
        "5. The Sphinx has the head of a lion and the body of a pharaoh."
    )

    // Array of correct answers for each question.
    private val answers = arrayOf(
        true,
        true,
        false,
        true,
        false
    )

    // Track the current question and the user's score.
    private var currentQuestionIndex = 0
    private var score = 0

    // Declare UI Elements.
    private lateinit var questionTextView: TextView
    private lateinit var feedbackTextView: TextView
    private lateinit var trueBtn: Button
    private lateinit var falseBtn: Button
    private lateinit var nextBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        // Initialise UI Elements.
        feedbackTextView = findViewById(R.id.feedbackTextView)
        questionTextView = findViewById(R.id.questionTextView)
        trueBtn = findViewById(R.id.trueBtn)
        falseBtn = findViewById(R.id.falseBtn)
        nextBtn = findViewById(R.id.nextBtn)

        //Set up animated background.
        val constraintLayout = findViewById<ConstraintLayout>(R.id.constraintLayout)
        val animationDrawable = constraintLayout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(1000) // Fade-in duration.
        animationDrawable.setExitFadeDuration(2000) // Fade-out duration.
        animationDrawable.start()

        // Display the 1st question.
        displayQuestion()

        // "False" button click.
        falseBtn.setOnClickListener { checkAnswer(false) }

        // "True" button click.
        trueBtn.setOnClickListener {checkAnswer(true) }

        // "Next" button click.
        nextBtn.setOnClickListener {
            currentQuestionIndex++
            if (currentQuestionIndex < questions.size) {
                // Show next question if available.
                displayQuestion()
            } else {
                // No more questions: move onto final score page.
                val intent = Intent(this, UserScoreActivity::class.java)
                intent.putExtra("Score:", score)
                intent.putExtra("Total:", questions.size)
                startActivity(intent)
                finish()
            }
        }
    }

    // Display the current question and reset buttons.
    private fun displayQuestion() {
        trueBtn.isEnabled = true
        falseBtn.isEnabled = true
        questionTextView.text = questions[currentQuestionIndex]
        feedbackTextView.text = ""
        nextBtn.isEnabled = false
    }


    // Check if user answer matches the correct one.
    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = answers[currentQuestionIndex]
        if (userAnswer == correctAnswer) {
            feedbackTextView.text = "That's Correct!"
            score++
        } else {
            feedbackTextView.text = "Oops... Not quite right..."
        }

        // Disable answer buttons and enable the Next button.
        trueBtn.isEnabled = false
        falseBtn.isEnabled = false
        nextBtn.isEnabled = true
    }
}
