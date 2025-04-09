package com.example.placement_portal

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SuccessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)

        // Set up toolbar
        setSupportActionBar(findViewById(R.id.toolbar))

        // Retrieve and display student profile data
        val fullName = intent.getStringExtra("fullName")
        val tvProfile = findViewById<TextView>(R.id.tv_profile)
        tvProfile.text = "Welcome, $fullName!"
    }

    // Inflate the menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    // Handle menu item clicks
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_dashboard -> {
                startActivity(Intent(this, DashboardActivity::class.java))
                true
            }
            R.id.menu_profile -> {
                startActivity(Intent(this, SuccessActivity::class.java))
                true
            }
            R.id.menu_apply_jobs -> {
                startActivity(Intent(this, ApplyJobsActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
