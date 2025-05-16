package com.program.easyorder

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.program.easyorder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Declare binding variable
    private lateinit var binding: ActivityMainBinding

    // Creating key
    companion object {
        const val KEY = "com.program.passdatatootherscreen.MainActivity.KEY"
        /*
        const is used to declare a compile-time constant.
        val means the value is immutable (read-only).
        Together, const val creates a constant whose value is determined at compile-time, not runtime.
        */
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize binding
                binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOrder.setOnClickListener {
            val orderPlacedList = binding.et1.text.toString() + ", " +
                    binding.et2.text.toString() + ", " +
                    binding.et3.text.toString() + ", " +
                    binding.et4.text.toString()


            intent = Intent(this,OrderActivity::class.java)
            intent.putExtra(KEY, orderPlacedList)

            startActivity(intent)
        }

    }
}