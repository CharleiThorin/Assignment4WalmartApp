package com.example.charles.walmartapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.charles.walmartapp.databinding.ActivityItemListBinding

class ItemList: AppCompatActivity(){
    private lateinit var binder: ActivityItemListBinding

    private val productList: ArrayList<Product> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivityItemListBinding.inflate(layoutInflater)
        setContentView(binder.root)

        productList.add(
            Product(
            "OMEN 27i Monitor",
            409.99,
            "Black",
            itemId = "13488",
            desc = "The NVIDIA® G-SYNC® Compatible[3] OMEN 27i monitor is validated by NVIDIA to bring you smooth, " +
                    "tear-free gaming with a 165Hz refresh rate[1] and 1ms response time with overdrive[1]. Fun just got fast.",
            image = R.drawable.hp
        ))
        productList.add(
            Product(
                "Dell 20 Monitor - P2018H",
                209.99,
                "Black",
                itemId = "3488",
                desc = " View your applications, spreadsheets and more on a 19.5 inch monitor " +
                        "with 1600x900 HD clarity, 16.7 million colors, and a contrast ratio of 1000:1.",
                image = R.drawable.dell
            ))

        binder.recycler.layoutManager = LinearLayoutManager(this@ItemList)
        binder.recycler.adapter = ItemAdapter(productList,this@ItemList)
    }
}