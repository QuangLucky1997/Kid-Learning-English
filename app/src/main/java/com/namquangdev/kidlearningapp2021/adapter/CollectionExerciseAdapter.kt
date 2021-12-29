package com.namquangdev.kidlearningapp2021.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.namquangdev.kidlearningapp2021.R
import com.namquangdev.kidlearningapp2021.`interface`.ClickListener
import com.namquangdev.kidlearningapp2021.model.Collection
import kotlinx.android.synthetic.main.custom_recycle_view_learning.view.*

class CollectionExerciseAdapter(
    private val context: Context,
    private val listCollection: List<Collection>,
    private var onClickMenu: ClickListener
) : RecyclerView.Adapter<CollectionExerciseAdapter.CollectionHolder>() {
    class CollectionHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionHolder {
        return CollectionHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.custom_recycle_view_learning, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CollectionHolder, position: Int) {
        val listData = listCollection[position]
        holder.itemView.img_collection.setImageResource(listData.img)
        holder.itemView.text_collection.text = listData.nameCard
        holder.itemView.cardViewText.setCardBackgroundColor(ContextCompat.getColor(context, listData.colors))
        holder.itemView.img_collection.setOnClickListener {
            onClickMenu.onClick(listData)
        }
        holder.itemView.layout_animation.animation= AnimationUtils.loadAnimation(holder.itemView.context, R.anim.translate)
    }

    override fun getItemCount(): Int {
        return listCollection.size
    }
}