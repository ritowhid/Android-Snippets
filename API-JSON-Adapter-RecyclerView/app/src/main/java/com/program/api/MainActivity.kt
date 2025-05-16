package com.program.api

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView = findViewById(R.id.recyclerView)
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getProductData()

        retrofitData.enqueue(object : Callback<MyData?> {

            override fun onResponse(p0: Call<MyData?>, response: Response<MyData?>) {
                // if api call success then use the data of api and show in your application
                var responseBody = response.body()
                val productList = responseBody?.products!!

                myAdapter = MyAdapter(this@MainActivity, productList)
                recyclerView.adapter = myAdapter
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

            }

            override fun onFailure(p0: Call<MyData?>, t: Throwable) {
                // if api call failed
                Log.d("Main Activity", "onFailure: " + t.message)
            }
        })

    }
}
/*
1. get api: example-DummyJson
2. Add retrofit dependency: from gradle take implementation code or from github with version
3. Add Gjson from retrofit: add dependency from Gjson github or Take converter version direct from website, it will show beside with Gjon- copy this and add in gradle
4. copy the api and create a kotlin  data class -> (add plugin Json to Kotlin) -> Paste the API -> Format -> Give class name -> Generate
5. use format json data to better understand of API, paste the copied api in the website
6. create new API interface
7. Give internet permission
8. Use picasso to load image

 */