package com.program.customizedalertboxes

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.program.customizedalertboxes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    // create a variable of type dialog
    private lateinit var dialog : Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the custom dialog
        dialog = Dialog(this)
        dialog.setContentView(R.layout.custom_dialogue) // Load the custom dialog layout
        dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.bg_alert_box))

        val btnFeedback = dialog.findViewById<Button>(R.id.btnFeedback)
        val btnGood = dialog.findViewById<Button>(R.id.btnGood)

        // set click listener for the buttons in the dialog
        btnFeedback.setOnClickListener {
            // intents: giving a form to receives feedback or Toast
        }

        btnGood.setOnClickListener {
            dialog.dismiss()
        }

        binding.btnClick.setOnClickListener {
            dialog.show()
        }

    }
}