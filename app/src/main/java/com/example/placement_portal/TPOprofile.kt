package com.example.placement_portal

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class TPOprofile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tpoprofile)

        // Initialize Image Buttons
        val btnDashboard = findViewById<ImageButton>(R.id.btnDashboard)
        val btnJobAppliedStudents = findViewById<ImageButton>(R.id.btnJobAppliedStudents)
        val btnPostJobs = findViewById<ImageButton>(R.id.btnPostJobs)

        // Navigate to Dashboard
        btnDashboard.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }

        // Navigate to Job Applied Students Page
        btnJobAppliedStudents.setOnClickListener {
            val intent = Intent(this, JobAppliedStudents::class.java)
            startActivity(intent)
        }

        // Navigate to Post Jobs Page
        btnPostJobs.setOnClickListener {
            val intent = Intent(this, PostJobs::class.java)
            startActivity(intent)
        }
    }
}
