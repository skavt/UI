package com.example.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.util.*

class AppScreenshotsAdapter(
    private val screenShotsList: ArrayList<String>,
    private val mContext: Context
) :
    RecyclerView.Adapter<AppScreenshotsAdapter.AppViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_screenshot, parent, false)
        return AppViewHolder(view)
    }

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        Glide.with(mContext)
            .load(getImage(screenShotsList[position]))
            .into(holder.screenshotImage)
    }

    private fun getImage(imageName: String): Int {
        return mContext.resources.getIdentifier(imageName, "drawable", mContext.packageName)
    }

    override fun getItemCount(): Int {
        return screenShotsList.size
    }

    inner class AppViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val screenshotImage: ImageView = itemView.findViewById(R.id.iv_screenshot)
    }
}