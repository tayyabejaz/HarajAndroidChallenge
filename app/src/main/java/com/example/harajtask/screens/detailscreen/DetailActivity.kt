package com.example.harajtask.screens.detailscreen

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.harajtask.R
import com.example.harajtask.model.Car
import com.example.harajtask.utils.DateTimeUtils
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        //Reading the data from the intent
        val gson = Gson()
        val post = gson.fromJson<Car>(intent.getStringExtra("posts"), Car::class.java)

        populateViews(post)

        ivShare.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Post Details: ${post.title}")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, "Post Details")
            startActivity(shareIntent)
        }

    }

    private fun populateViews(item: Car) {
        ivCarImage.setImageURI(item.thumbURL)
        tvTitle.text = item.title
        tvCity.text = item.city
        tvDate.text = DateTimeUtils.formatCarDate(item.date ?: 0L)
        tvUserName.text = item.username
        tvBody.text = item.body
    }
}