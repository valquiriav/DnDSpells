package com.valquiria.dndspells.presentation.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.valquiria.dndspells.Constants.TIME_SPLASH_TO_MAIN_ACTIVITY
import com.valquiria.dndspells.R

class SplashScreenActivity: AppCompatActivity(R.layout.activity_splash_screen) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, TIME_SPLASH_TO_MAIN_ACTIVITY)
    }
}