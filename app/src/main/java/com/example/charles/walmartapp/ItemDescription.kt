package com.example.charles.walmartapp

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.charles.walmartapp.databinding.ActivityItemDescriptionBinding

class ItemDescription : AppCompatActivity(){
    private lateinit var itemBinder: ActivityItemDescriptionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        itemBinder = ActivityItemDescriptionBinding.inflate(layoutInflater)
        setContentView(itemBinder.root)

        val product = intent.extras?.get("product") as Product

        itemBinder.color.text = product.color
        itemBinder.title.text = product.title
        itemBinder.productId.text = product.itemId
        itemBinder.desc.text = product.desc

        Glide.with(this@ItemDescription)
            .load(product.image)
            .into(itemBinder.imageView)
    }
}