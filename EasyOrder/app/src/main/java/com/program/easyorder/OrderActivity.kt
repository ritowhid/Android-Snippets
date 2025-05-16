package com.program.easyorder

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.program.easyorder.databinding.ActivityOrderBinding

class OrderActivity : AppCompatActivity() {
    // Declare binding variable
    private lateinit var binding: ActivityOrderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize binding
                binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve the order list passed via Intent
        val orderOfCustomers = intent.getStringExtra(MainActivity.KEY)

        // Set the retrieved order list to the TextView
        binding.txtOrder.text = orderOfCustomers
    }
}