package com.campusnet.higher_lower

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity

class FinishActivity : AppCompatActivity() {
    private lateinit var finishlayout: RelativeLayout
    private lateinit var finishLogo: ImageView
    private lateinit var backToMenu: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        finishlayout = findViewById(R.id.finish)
        finishLogo = findViewById(R.id.finishImage)
        backToMenu = findViewById(R.id.goMenu)

        val gameResult = intent.getStringExtra("GAME_RESULT")

        if (gameResult != null) {
            if (gameResult == "WIN")
            {
                showWinLayout()
            }
            else if (gameResult == "LOSE")
            {
                showLoseLayout()
            }
        }



        backToMenu.setOnClickListener {
            backToMenu()
        }
    }

    private fun showWinLayout() {
        finishlayout.setBackgroundResource(R.drawable.winbackgorund)
        finishLogo.setImageResource(R.drawable.wintitle)
    }

    private fun showLoseLayout() {
        finishlayout.setBackgroundResource(R.drawable.losebackground)
        finishLogo.setImageResource(R.drawable.losetitle)
    }

    private fun backToMenu() {
        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
    }
}