package com.example.placement_portal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find CheckBoxes & Button
        val checkBoxStudent = findViewById<CheckBox>(R.id.checkbox_student)
        val checkBoxTPO = findViewById<CheckBox>(R.id.checkbox_tpo) // Training and Placement Officer
        val btnSubmit = findViewById<Button>(R.id.btn_submit)

        // Initially disable the Submit button
        btnSubmit.isEnabled = false

        // List of all checkboxes
        val checkBoxes = listOf(checkBoxStudent, checkBoxTPO)

        // Enable/Disable submit button based on checkbox selection
        checkBoxes.forEach { checkBox ->
            checkBox.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    checkBoxes.forEach { cb ->
                        if (cb != checkBox) cb.isChecked = false // Uncheck others
                    }
                    btnSubmit.isEnabled = true
                } else {
                    btnSubmit.isEnabled = checkBoxes.any { it.isChecked }
                }
            }
        }

        // Handle Submit Button Click
        btnSubmit.setOnClickListener {
            val selectedRole = checkBoxes.find { it.isChecked }?.text.toString()

            // Navigate to the corresponding login activity
            val intent = when (selectedRole) {
                getString(R.string.checkbox_student) -> Intent(this, Studentlogin::class.java)
                getString(R.string.checkbox_tpo) -> Intent(this, TPOLogin::class.java)
                else -> null
            }

            if (intent != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please select a valid role", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
