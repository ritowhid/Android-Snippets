package com.program.listviewp2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.program.listviewp2.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val phoneNumber = intent.getStringExtra("phone")
        val imageId = intent.getIntExtra("imageId", R.drawable.pic1)

        binding.tvName.text = name
        binding.tvPhone.text = phoneNumber
        binding.profileImage.setImageResource(imageId)
    }
}
