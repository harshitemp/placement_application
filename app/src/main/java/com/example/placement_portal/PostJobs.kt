package com.example.placement_portal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PostJobs : AppCompatActivity() {

    private lateinit var etJobTitle: EditText
    private lateinit var etCompanyName: EditText
    private lateinit var etJobDescription: EditText
    private lateinit var etJobLocation: EditText
    private lateinit var etSalary: EditText
    private lateinit var etEligibility: EditText
    private lateinit var etDeadline: EditText
    private lateinit var btnPostJob: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_jobs)

        // Initialize views
        etJobTitle = findViewById(R.id.etJobTitle)
        etCompanyName = findViewById(R.id.etCompanyName)
        etJobDescription = findViewById(R.id.etJobDescription)
        etJobLocation = findViewById(R.id.etJobLocation)
        etSalary = findViewById(R.id.etSalary)
        etEligibility = findViewById(R.id.etEligibility)
        etDeadline = findViewById(R.id.etDeadline)
        btnPostJob = findViewById(R.id.btnPostJob)

        // Navigation Buttons
        val btnDashboard = findViewById<ImageButton>(R.id.btnDashboard)
        val btnJobAppliedStudents = findViewById<ImageButton>(R.id.btnJobAppliedStudents)
        val btnPostJobs = findViewById<ImageButton>(R.id.btnPostJobs)

        // Post Job button click listener
        btnPostJob.setOnClickListener {
            postJob()
        }

        // Navigation button click listeners
        btnDashboard.setOnClickListener {
            startActivity(Intent(this, Dashboard::class.java))
        }

        btnJobAppliedStudents.setOnClickListener {
            startActivity(Intent(this, JobAppliedStudents::class.java))
        }

        btnPostJobs.setOnClickListener {
            startActivity(Intent(this, PostJobs::class.java))
        }
    }

    private fun postJob() {
        val jobTitle = etJobTitle.text.toString().trim()
        val companyName = etCompanyName.text.toString().trim()
        val jobDescription = etJobDescription.text.toString().trim()
        val jobLocation = etJobLocation.text.toString().trim()
        val salary = etSalary.text.toString().trim()
        val eligibility = etEligibility.text.toString().trim()
        val deadline = etDeadline.text.toString().trim()

        if (jobTitle.isEmpty() || companyName.isEmpty() || jobDescription.isEmpty() ||
            jobLocation.isEmpty() || salary.isEmpty() || eligibility.isEmpty() || deadline.isEmpty()
        ) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            return
        }

        // Simulate job posting (Save to database or API call here)
        Toast.makeText(this, "Job posted successfully!", Toast.LENGTH_LONG).show()

        // Clear fields after successful posting
        clearFields()
    }

    private fun clearFields() {
        etJobTitle.text.clear()
        etCompanyName.text.clear()
        etJobDescription.text.clear()
        etJobLocation.text.clear()
        etSalary.text.clear()
        etEligibility.text.clear()
        etDeadline.text.clear()
    }
}
