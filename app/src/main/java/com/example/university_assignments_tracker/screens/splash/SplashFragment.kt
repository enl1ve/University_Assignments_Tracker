package com.example.university_assignments_tracker.screens.splash

import android.content.Intent
import androidx.fragment.app.Fragment
import com.example.university_assignments_tracker.R
import com.example.university_assignments_tracker.screens.MainActivity
import com.example.university_assignments_tracker.screens.MainActivityArgs

class SplashFragment : Fragment(R.layout.fragment_splash) {
    private fun launchMainScreen(isSignedIn: Boolean) {
        val intent = Intent(requireContext(), MainActivity::class.java)

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)

        val args = MainActivityArgs(isSignedIn)
        intent.putExtras(args.toBundle())
        startActivity(intent)
    }
}