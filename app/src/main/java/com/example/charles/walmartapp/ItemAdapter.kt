package com.example.charles.walmartapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.charles.walmartapp.databinding.ActivityListItemBinding


class ItemAdapter(private val list: List<Product>, private val context: Context) : RecyclerView.Adapter<ItemAdapter.OurViewHolder>() {

    class OurViewHolder(view: ActivityListItemBinding) : RecyclerView.ViewHolder(view.root) {
        val title = view.itemLabel
        val price = view.itemPrice
        val color = view.itemColor
        val layout = view.layout
        val imageView = view.imageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OurViewHolder {
        val holder = ActivityListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OurViewHolder(holder)
    }

    override fun onBindViewHolder(holder: OurViewHolder, position: Int) {
        holder.title.text = list[position].title
        holder.price.text = "Price: ${list[position].price}"
        holder.color.text = "Color: ${list[position].color}"

        holder.imageView.setImageDrawable(
            ResourcesCompat.getDrawable(context.resources, list[position].image, null))

        holder.layout.setOnClickListener {
            Intent(context, ItemDescription::class.java).also {
                it.putExtra("product", list[position])
                context.startActivity(it)
            }
        }
    }

    override fun getItemCount(): Int = list.size
}
