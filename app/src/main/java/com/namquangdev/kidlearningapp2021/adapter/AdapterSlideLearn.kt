package com.namquangdev.kidlearningapp2021.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.namquangdev.kidlearningapp2021.R
import com.namquangdev.kidlearningapp2021.`interface`.ClickListener
import com.namquangdev.kidlearningapp2021.data.model.Collection
import com.namquangdev.kidlearningapp2021.data.model.DataLearn
import kotlinx.android.synthetic.main.custom_learn.view.*
import kotlinx.android.synthetic.main.custom_recycle_view_learning.view.*

class AdapterSlideLearn(
    private val context: Context,
    private val listLearn: List<DataLearn>,
) : RecyclerView.Adapter<AdapterSlideLearn.LearnHolder>() {
    class LearnHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearnHolder {
        return LearnHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.custom_learn, parent, false)
        )
    }

    override fun onBindViewHolder(holder: LearnHolder, position: Int) {
        val listData = listLearn[position]
        Glide.with(context).load(listData.url).into(holder.itemView.img_collection)
        holder.itemView.text_name.text = listData.name
    }

    override fun getItemCount(): Int {
        return listLearn.size
    }
}