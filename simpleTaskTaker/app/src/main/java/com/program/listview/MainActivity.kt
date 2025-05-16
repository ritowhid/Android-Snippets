package com.program.listview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.program.listview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Data to display in the ListView
        val taskList = arrayListOf(
            "Complete assignment",
            "Buy groceries",
            "Call mom",
            "Go for a walk",
            "Finish reading the book",
            "Attend Exam"
        )

        // Set up ArrayAdapter for the ListView
        val adapterForMyListView = ArrayAdapter(this, android.R.layout.simple_list_item_1, taskList)

        // Attach the adapter to the listView using binding
        binding.listView.adapter = adapterForMyListView

        // Set onClickListener for list items
        binding.listView.setOnItemClickListener { parent, view, position, id ->
            val text = "Clicked on item : " + taskList[position]
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
    }
}