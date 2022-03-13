package com.example.charles.walmartapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.charles.walmartapp.databinding.ActivityShoppingBinding

class ShoppingActivity : Activity(){
    private lateinit var shopBinder: ActivityShoppingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shopBinder = ActivityShoppingBinding.inflate(layoutInflater)
        setContentView(shopBinder.root)

        shopBinder.userName.text = "Welcome " + intent.extras?.getString("username")

        shopBinder.clothing.setOnClickListener{
            toast(ActivityShoppingBinding::clothing.name)
        }

        shopBinder.electronics.setOnClickListener{
            toast(ActivityShoppingBinding::electronics.name)
            Intent(this@ShoppingActivity, ItemList::class.java).also { startActivity(it) }
        }

        shopBinder.beauty.setOnClickListener{
            toast(ActivityShoppingBinding::beauty.name)
        }

        shopBinder.food.setOnClickListener {
            toast(ActivityShoppingBinding::food.name)
        }

    }

    private fun toast(name: String) {
        Toast.makeText(this,"Hi there!, your category is $name", Toast.LENGTH_SHORT).show()
    }
}