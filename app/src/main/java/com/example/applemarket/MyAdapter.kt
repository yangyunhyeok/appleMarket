package com.example.applemarket

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applemarket.databinding.ItemRecyclerviewBinding
import java.text.DecimalFormat

class MyAdapter(val dataList:MutableList<SalesItems>) :RecyclerView.Adapter<MyAdapter.Holder>() {

    inner class Holder(val binding:ItemRecyclerviewBinding):RecyclerView.ViewHolder(binding.root){
        val image = binding.image
        val title = binding.title
        val address = binding.address
        val price = binding.price
        val comment = binding.commentCount
        val like = binding.likeCount
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder:Holder, position: Int) {
        val t_dec_up = DecimalFormat("#,###")

        holder.image.setImageResource(dataList[position].image)
        holder.title.text = dataList[position].title
        holder.address.text = dataList[position].address
        holder.price.text = t_dec_up.format(dataList[position].price)+"원"
        holder.comment.text = dataList[position].comment.toString()
        holder.like.text = dataList[position].like.toString()
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}