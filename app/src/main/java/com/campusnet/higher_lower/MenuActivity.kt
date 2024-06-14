package com.campusnet.higher_lower

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val startVehicles = findViewById<Button>(R.id.playVehicles)
        var startAnimals = findViewById<Button>(R.id.playAnimals)
        var startSports = findViewById<Button>(R.id.playSports)
        var startRandom = findViewById<Button>(R.id.playRandom)

        startVehicles.setOnClickListener {
            GameManager.quizType = 0;
            startGame()
        }

        startAnimals.setOnClickListener {
            GameManager.quizType = 1;
            startGame()
        }

        startSports.setOnClickListener {
            GameManager.quizType = 2;
            startGame()
        }

        startRandom.setOnClickListener {
            GameManager.quizType = 3;
            startGame()
        }
    }

    private fun startGame()
    {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}

