package com.example.placement_portal

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.placement_portal.R

class TPORegistration : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tporegistration)

        val etTpoName = findViewById<EditText>(R.id.etTpoName)
        val etTpoEmail = findViewById<EditText>(R.id.etTpoEmail)
        val etTpoPhone = findViewById<EditText>(R.id.etTpoPhone)
        val etTpoPassword = findViewById<EditText>(R.id.etTpoPassword)
        val etTpoConfirmPassword = findViewById<EditText>(R.id.etTpoConfirmPassword)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val name = etTpoName.text.toString().trim()
            val email = etTpoEmail.text.toString().trim()
            val phone = etTpoPhone.text.toString().trim()
            val password = etTpoPassword.text.toString().trim()
            val confirmPassword = etTpoConfirmPassword.text.toString().trim()

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "All fields are required!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show()

            // Navigate to TPO Profile with data
            val intent = Intent(this, TPOprofile::class.java).apply {
                putExtra("TPO_NAME", name)
                putExtra("TPO_EMAIL", email)
                putExtra("TPO_PHONE", phone)
            }
            startActivity(intent)
            finish()
        }
    }
    }
