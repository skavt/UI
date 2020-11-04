package com.example.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.image_item.view.*

class AppImagesAdapter(
    private val imageList: ArrayList<String>,
    private val context: Context
) :
    RecyclerView.Adapter<AppImagesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context).load(getImage(imageList[position])).into(holder.screenshotImage)
    }

    override fun getItemCount(): Int = imageList.size

    private fun getImage(imageName: String): Int =
        context.resources.getIdentifier(imageName, "drawable", context.packageName)

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val screenshotImage: ImageView = itemView.image
    }
}