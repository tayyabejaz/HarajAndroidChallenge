package com.example.harajtask.screens.mainscreen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.harajtask.MainAdapter
import com.example.harajtask.R
import com.example.harajtask.model.Car
import com.example.harajtask.screens.detailscreen.DetailActivity
import com.example.harajtask.utils.DataUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import okio.IOException
import okio.buffer
import okio.source
import java.lang.reflect.Type
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {

    private var carAdapter: MainAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Read the Data from Assets Json file
        val data = DataUtils.readDataFromAssets(this, "data.json")

        //Convert the data to the respective DataType in the List
        val posts: Type = object : TypeToken<List<Car?>?>() {}.type

        //Using Gson convert the data to the List
        if (data != null) {
            val convertedData: List<Car> = Gson().fromJson(data, posts)
            initRecyclerView(convertedData)
        }
    }

    //Initializing the Recyclerview with the respective data
    private fun initRecyclerView(data: List<Car>) {
        carAdapter = MainAdapter(this, data) {
            //To pass the data to another activity, convert object into Json and then send the data to another activity
            val gson = Gson()
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("posts", gson.toJson(it))
            startActivity(intent)
        }

        rvMainCar.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rvMainCar.adapter = carAdapter
    }
}

