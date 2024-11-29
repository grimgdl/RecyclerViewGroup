package com.grimco.recyclergroup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.grimco.recyclergroup.databinding.DetailActivityBinding

class DetailActivity: AppCompatActivity() {

    private lateinit var binding: DetailActivityBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val url = intent.extras?.getString("url", "")

        Glide.with(this)
            .load(url)
            .centerCrop()
            .into(binding.image)
    }

}