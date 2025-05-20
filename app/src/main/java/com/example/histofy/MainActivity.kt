/*setOnClickListener & findViewByID Tutorial - https://youtu.be/Cw3F7NeaI3I?si=AM1wfIaBfORFwNcm
* Exit Button Tutorial - https://youtu.be/Yx63M4k-EeE?si=nP31E2SQISxRnZHZ
* Access & Declare UI Elements - https://youtu.be/fUAi_RCCNIg?si=MVpZ6manAeX-KcgI
* How to move from one activity to another - https://youtu.be/JOdWT50bWw4?si=WYjRpKSvAl_6iJGN
* W3 Schools - https://www.w3schools.com
* How to Change Android Studio Font Family Tutorial - https://youtu.be/hALSwU7g36M
 */

package com.example.histofy
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.histofy.R

class MainActivity : AppCompatActivity() {

    // Declare UI Elements.
    private lateinit var startBtn: Button
    private lateinit var exitBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initialise UI Elements.
        val startBtn: Button = findViewById(R.id.startBtn)
        val exitBtn: Button = findViewById(R.id.exitBtn)

        // Set an onClick listener for the Start button.
        // When clicked, it creates an Intent to move from MainActivity to FlashcardDisplay.
        startBtn.setOnClickListener { val intent = Intent(this, FlashcardDisplay::class.java) // Create navigation Intent.
            startActivity(intent) }

        // Set onClick listener for the Exit button.
        // When clicked, it finishes (closes) the current activity.
        exitBtn.setOnClickListener {
            finish()
        }

        // Find the layout so it can apply background animation to it.
        val constraintLayout = findViewById<ConstraintLayout>(R.id.constraintLayout)

        // Cast the background of the layout to an AnimationDrawable so it can be animated.
        val animationDrawable = constraintLayout.background as AnimationDrawable

        // Configure the animation settings.
        animationDrawable.apply {
            setEnterFadeDuration(1000) // Duration of the fade-in animation.
            setExitFadeDuration(2000) // Duration of the fade-out animation.
            start()
        }
    }
}
