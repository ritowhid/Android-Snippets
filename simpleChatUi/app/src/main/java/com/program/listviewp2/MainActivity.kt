package com.program.listviewp2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.program.listviewp2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var userArrayList:ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = arrayOf("Rakibul", "Islam", "Towhid", "Musa", "Umar")
        val lastMs = arrayOf("Hey wssup", "I am well", "What is this", "Hope you are well", "It's great")
        val lastMsTime = arrayOf("6:25", "7:30", "7:45", "8:33", "4:45")
        val phone = arrayOf("01234567899","01855567899","01752525364", "01325413671", "01953621456")
        val imageID = intArrayOf(R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5)

        userArrayList = ArrayList()

        // Populate the userArrayList
        for (eachIndex in name.indices) {
            val user = User(
                name[eachIndex],
                lastMs[eachIndex],
                lastMsTime[eachIndex],
                phone[eachIndex],
                imageID[eachIndex]
            )
            userArrayList.add(user)
        }
        binding.listView.isClickable = true
        binding.listView.adapter = MyAdapter(this, userArrayList)

        binding.listView.setOnItemClickListener { parent, view, position, id ->
            val userName = name[position]
            val userPhone = phone[position]
            val imgId = imageID[position] // Get the selected user's image ID

            val i = Intent(this, UserActivity::class.java)
            i.putExtra("name", userName)
            i.putExtra("phone", userPhone)
            i.putExtra("imageId", imgId) // Pass the correct image ID
            startActivity(i)
        }
    }
}