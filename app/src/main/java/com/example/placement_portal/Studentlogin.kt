package com.example.placement_portal

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.placement_portal.R
import com.example.placement_portal.StudentRegistration

class Studentlogin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_studentlogin)

        val etUsername = findViewById<EditText>(R.id.et_username)
        val etPassword = findViewById<EditText>(R.id.et_password)
        val btnLogin = findViewById<Button>(R.id.btn_login)

        // Disable login button initially
        btnLogin.isEnabled = false

        // Enable button when both fields are filled
        val textWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                btnLogin.isEnabled = etUsername.text.isNotEmpty() && etPassword.text.isNotEmpty()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        }

        etUsername.addTextChangedListener(textWatcher)
        etPassword.addTextChangedListener(textWatcher)

        // Handle login button click
        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            // Simple validation (you can customize this logic)
            if (username == "admin" && password == "admin") {
                // Navigate to the next activity
                startActivity(Intent(this, StudentRegistration::class.java))
                finish()
            } else {
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
