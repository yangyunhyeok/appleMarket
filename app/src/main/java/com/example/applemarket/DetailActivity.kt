package com.example.applemarket

import android.content.Intent
import android.content.res.Resources
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.content.res.ResourcesCompat
import com.example.applemarket.databinding.ActivityDetailBinding
import com.example.applemarket.databinding.ActivityMainBinding


class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backpoint.setOnClickListener {
            val intent = Intent(it.context,MainActivity::class.java)
            startActivity(intent)
        }
        binding.image.setImageResource(intent.getIntExtra("image",0))
        binding.name.text = intent.getStringExtra("user")
        binding.address.text = intent.getStringExtra("address")
        binding.title.text = intent.getStringExtra("title")
        binding.text.text = intent.getStringExtra("text")
        binding.price.text = intent.getStringExtra("price")

        // 사진, 이름, 주소, 타이틀, 내용
    }
}