package com.example.university_assignments_tracker.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.university_assignments_tracker.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun isSignedIn(): Boolean {
        val bundle = intent.extras ?: throw IllegalStateException("No required arguments")
        val args = MainActivityArgs.fromBundle(bundle)
        return args.isSignedIn
    }

    private fun getMainNavigationGraphId(): Int = R.id.main_graph

    private fun getTabsDestination(): Int = R.id.tabsFragment

    private fun getSignInDestination(): Int = R.id.signInFragment

}