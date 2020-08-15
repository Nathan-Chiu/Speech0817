package com.example.speechapp0817.recyclerview

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.speechapp0817.R
import com.example.speechapp0817.data.ArticlesItem

import com.example.speechapp0817.recyclerview.dummy.DummyContent.DummyItem

/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyItemRecyclerViewAdapter(
    val context: Context,
    private val values: List<ArticlesItem>
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = when(viewType){
            0 -> LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_item, parent, false)
            else -> LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_item_2, parent, false)
        }
        return ViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return if( position.rem(2) == 0){
            0
        } else {
            1
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.title
        holder.contentView.text = item.content
        Glide.with(context)
            .load(item.urlToImage)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val idView: TextView = view.findViewById(R.id.item_number)
        val contentView: TextView = view.findViewById(R.id.content)
        val imageView: ImageView = view.findViewById(R.id.imageView)

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }
}