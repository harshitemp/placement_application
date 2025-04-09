package com.example.placement_portal

import android.app.DatePickerDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class StudentRegistration : AppCompatActivity() {

    private lateinit var etFullName: EditText
    private lateinit var etDob: EditText
    private lateinit var rgGender: RadioGroup
    private lateinit var etContact: EditText
    private lateinit var etEmail: EditText
    private lateinit var btnUploadResume: Button
    private lateinit var btnSubmit: Button

    private var resumeUri: Uri? = null
    private val PICK_RESUME_REQUEST = 100
    private val MAX_FILE_SIZE_MB = 2 * 1024 * 1024 // 2MB in bytes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_registration)

        // Initialize views
        etFullName = findViewById(R.id.et_full_name)
        etDob = findViewById(R.id.et_dob)
        rgGender = findViewById(R.id.rg_gender)
        etContact = findViewById(R.id.et_contact)
        etEmail = findViewById(R.id.et_email)
        btnUploadResume = findViewById(R.id.btn_upload_resume)
        btnSubmit = findViewById(R.id.btn_submit)

        // Open Date Picker for DOB
        etDob.setOnClickListener {
            showDatePicker()
        }

        // Upload Resume (Optional)
        btnUploadResume.setOnClickListener {
            openFilePicker()
        }

        // Submit Form
        btnSubmit.setOnClickListener {
            validateAndSubmit()
        }
    }

    // Date picker for Date of Birth
    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePicker = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            etDob.setText("$selectedDay/${selectedMonth + 1}/$selectedYear")
        }, year, month, day)
        datePicker.show()
    }

    // Open file picker to upload resume (Optional)
    private fun openFilePicker() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "application/pdf" // Allow only PDF resumes
        startActivityForResult(intent, PICK_RESUME_REQUEST)
    }

    // Handle the resume upload result
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_RESUME_REQUEST && resultCode == RESULT_OK) {
            data?.data?.let { uri ->
                contentResolver.openInputStream(uri)?.use { inputStream ->
                    val fileSize = inputStream.available()
                    if (fileSize > MAX_FILE_SIZE_MB) {
                        Toast.makeText(this, "File size exceeds 2MB limit", Toast.LENGTH_SHORT).show()
                        return
                    }
                }
                resumeUri = uri
                btnUploadResume.text = "Resume Selected"
            }
        }
    }

    // Validate input and submit the form
    private fun validateAndSubmit() {
        val fullName = etFullName.text.toString().trim()
        val dob = etDob.text.toString().trim()
        val contact = etContact.text.toString().trim()
        val email = etEmail.text.toString().trim()

        // Validate only required inputs
        if (fullName.isEmpty() || dob.isEmpty()) {
            Toast.makeText(this, "Full Name and Date of Birth are required", Toast.LENGTH_SHORT).show()
            return
        }

        if (contact.isNotEmpty() && !android.util.Patterns.PHONE.matcher(contact).matches()) {
            Toast.makeText(this, "Invalid contact number", Toast.LENGTH_SHORT).show()
            return
        }

        if (email.isNotEmpty() && !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Invalid email address", Toast.LENGTH_SHORT).show()
            return
        }

        // Proceed to next activity (Success Page)
        val intent = Intent(this, SuccessActivity::class.java)
        intent.putExtra("fullName", fullName)
        startActivity(intent)
        finish()
    }
}
