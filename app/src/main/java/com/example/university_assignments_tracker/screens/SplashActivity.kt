package com.example.university_assignments_tracker.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.university_assignments_tracker.R
import com.example.university_assignments_tracker.screens.splash.SplashFragment

/**
 * Entry point of the app.
 *
 * Splash activity contains only window background, all other initialization logic is placed to
 * [SplashFragment] and [SplashViewModel].
 */
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        //Repositories.init(applicationContext)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

}