package com.campusnet.higher_lower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.content.Intent

class MainActivity : AppCompatActivity() {

    private lateinit var testInfo:Array<Info>
    private lateinit var topImage:ImageView
    private lateinit var bottomImage:ImageView
    private lateinit var title1:TextView
    private lateinit var title2:TextView
    private lateinit var viewsText:TextView
    private lateinit var higherBtn:Button
    private lateinit var lowerBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testInfo = GameManager.GetNewInfo()

        title1 = findViewById(R.id.title1)
        title2 = findViewById(R.id.title2)
        topImage = findViewById(R.id.topImage)
        bottomImage = findViewById(R.id.bottomImage)
        viewsText = findViewById(R.id.textViews)
        higherBtn = findViewById(R.id.higherBtn)
        lowerBtn = findViewById(R.id.lowerBtn)

        printStage()
    }

    private fun printStage()
    {
        title1.setText(testInfo[GameManager.currentQuiz].name)
        viewsText.setText(testInfo[GameManager.currentQuiz].views.toString())
        topImage.setImageResource(testInfo[GameManager.currentQuiz].image)

        title2.setText(testInfo[GameManager.currentQuiz + 1].name)
        bottomImage.setImageResource(testInfo[GameManager.currentQuiz + 1].image)
    }

    public fun checkHigher(view: View)
    {
        if (testInfo[GameManager.currentQuiz + 1].views >= testInfo[GameManager.currentQuiz].views)
        {
            GameManager.currentQuiz++
            if (GameManager.currentQuiz >= testInfo.size -1)
            {
                //Win
                showWinScreen()
                return
            }
            printStage()
        }
        else
        {
            //Lose
            showLoseScreen()
        }
    }

    public fun checkLower(view: View)
    {
        if (testInfo[GameManager.currentQuiz + 1].views <= testInfo[GameManager.currentQuiz].views)
        {
            GameManager.currentQuiz++
            if (GameManager.currentQuiz >= testInfo.size -1)
            {
                //Win
                showWinScreen()
                return
            }
            printStage()
        }
        else
        {
            //Lose
            showLoseScreen()
        }
    }

    private fun showWinScreen() {
        val intent = Intent(this, FinishActivity::class.java)
        intent.putExtra("GAME_RESULT", "WIN")
        startActivity(intent)
    }

    private fun showLoseScreen() {
        val intent = Intent(this, FinishActivity::class.java)
        intent.putExtra("GAME_RESULT", "LOSE")
        startActivity(intent)
    }
}