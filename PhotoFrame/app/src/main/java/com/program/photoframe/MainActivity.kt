package com.program.photoframe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.program.photoframe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    /// Array of image resource IDs
    private val images = arrayOf(
        R.drawable.pic0,
        R.drawable.pic1,
        R.drawable.pic2,
        R.drawable.pic3
    )

    // Array of names corresponding to each image
    private val names = arrayOf(
        "Rakibul", "Islam", "Towhid", "Developer"
    )

    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set the initial image and name
        binding.img1.setImageResource(images[currentIndex])
        binding.imageName.text = names[currentIndex]

        // Previous button click listener
        binding.imgPrevious.setOnClickListener {
            // Update the current index to the previous one (looping back if necessary)
            currentIndex = if (currentIndex - 1 < 0) images.size - 1 else currentIndex - 1

            // Set the new image and name
            setImageAndName()
        }

        // Next button click listener
        binding.imgNext.setOnClickListener {
            // Update the current index to the next one (looping forward if necessary)
            currentIndex = (currentIndex + 1) % images.size

            // Set the new image and name
            setImageAndName()
        }
    }

    // Method to update image and name based on current index
    private fun setImageAndName() {
        // Update the image
        binding.img1.setImageResource(images[currentIndex])

        // Update the name
        binding.imageName.text = names[currentIndex]
    }
}