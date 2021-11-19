package com.example.harajtask

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.harajtask.model.Car
import com.example.harajtask.utils.DateTimeUtils
import kotlinx.android.synthetic.main.item_main_cars.view.*

class MainAdapter(var context: Context, var dataList: List<Car>, var itemClick: (Car) -> Unit) :
    RecyclerView.Adapter<MainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder =
        MainViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_main_cars, parent, false)
        )

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = dataList[position]

        holder.itemView.tvTitle.text = item.title
        holder.itemView.tvCity.text = item.city
        holder.itemView.ivCarImage.setImageURI(item.thumbURL)
        holder.itemView.tvCommentCount.text = item.commentCount.toString()
        holder.itemView.tvUserName.text = item.username
        holder.itemView.tvDate.text = DateTimeUtils.formatCarDate(item.date ?: 0L)
        holder.itemView.setOnClickListener {
            itemClick(item)
        }
    }

    override fun getItemCount(): Int = dataList.size
}

class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)