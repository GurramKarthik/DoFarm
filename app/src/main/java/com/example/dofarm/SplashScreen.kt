package com.example.dofarm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler


class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        val homeScreen = Intent(this, HomeScreen::class.java)

        Handler().postDelayed({
            startActivity(homeScreen)
            finish()
        },500
        )


    }
}