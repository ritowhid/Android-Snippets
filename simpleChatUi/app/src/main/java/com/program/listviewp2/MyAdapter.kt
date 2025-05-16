package com.program.listviewp2

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.program.listviewp2.databinding.EachitemBinding

class MyAdapter(private val context: Activity, private val arrayList: ArrayList<User>) :
    ArrayAdapter<User>(context, R.layout.eachitem, arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Use ViewBinding to inflate the layout
        val binding: EachitemBinding = if (convertView == null) {
            EachitemBinding.inflate(LayoutInflater.from(context), parent, false)
        } else {
            EachitemBinding.bind(convertView)
        }

        // Bind data to the views
        val currentUser = arrayList[position]
        binding.profileImage.setImageResource(currentUser.imageID)
        binding.tvName.text = currentUser.name
        binding.tvMessage.text = currentUser.lastMs
        binding.tvTime.text = currentUser.lastMsTime



        return binding.root
    }
}
