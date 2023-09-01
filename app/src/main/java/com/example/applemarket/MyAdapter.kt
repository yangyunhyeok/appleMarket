package com.example.applemarket

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.applemarket.databinding.ItemRecyclerviewBinding
import java.text.DecimalFormat

class MyAdapter(val dataList:MutableList<SalesItems>) :RecyclerView.Adapter<MyAdapter.Holder>() {

    interface ItemClick{
        fun onClick(view:View, position: Int)
    }
    var itemClick:ItemClick? = null
    inner class Holder(val binding:ItemRecyclerviewBinding):RecyclerView.ViewHolder(binding.root){
        val image = binding.image
        val title = binding.title
        val address = binding.address
        val price = binding.price
        val comment = binding.commentCount
        val like = binding.likeCount

    }
    // 사진, 이름, 주소, 타이틀, 내용
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }


    override fun onBindViewHolder(holder:Holder, position: Int) {

        holder.itemView.setOnClickListener {
            itemClick?.onClick(it,position)
        }

        val t_dec_up = DecimalFormat("#,###")

        holder.image.setImageResource(dataList[position].image)
        holder.title.text = dataList[position].title
        holder.address.text = dataList[position].address
        holder.price.text = t_dec_up.format(dataList[position].price)+"원"
        holder.comment.text = dataList[position].comment.toString()
        holder.like.text = dataList[position].like.toString()


        val detailMove = holder.binding.root
        detailMove.setOnClickListener {
            val intent = Intent(it.context,DetailActivity::class.java)

            intent.putExtra("image",dataList[position].image)
            intent.putExtra("user",dataList[position].user)
            intent.putExtra("address",dataList[position].address)
            intent.putExtra("title",dataList[position].title)
            intent.putExtra("text",dataList[position].text)
            intent.putExtra("price",t_dec_up.format(dataList[position].price)+"원")
            it.context.startActivity(intent)
            (it.context as Activity).overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
    fun ItemClick(binding: ItemRecyclerviewBinding, position: Int){

    }



}
