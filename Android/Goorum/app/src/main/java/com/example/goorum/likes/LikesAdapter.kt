package com.example.goorum.likes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.goorum.R

class LikesAdapter(val context: Context, val likesList: ArrayList<LikesData>,
                   val itemClick: (LikesData) -> Unit) : RecyclerView.Adapter<LikesAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.notification_list_item, parent, false)
        return Holder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return likesList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(likesList[position], context)
    }

    inner class Holder(itemView: View, itemClick: (LikesData) -> Unit) : RecyclerView.ViewHolder(itemView) {
        val writer = itemView.findViewById<TextView>(R.id.tvWriter)
        val title = itemView.findViewById<TextView>(R.id.tvTitle)
        val preview = itemView.findViewById<TextView>(R.id.tvContentPreview)
        val category = itemView.findViewById<TextView>(R.id.tvCategoryInfo)

        fun bind(likes: LikesData, context: Context) {
            writer.text = likes.writer
            title.text = likes.title
            preview.text = likes.content
            category.text = likes.category

            itemView.setOnClickListener {itemClick(likes)}
        }
    }
}