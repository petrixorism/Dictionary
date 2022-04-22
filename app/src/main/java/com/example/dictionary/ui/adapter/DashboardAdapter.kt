package com.example.dictionary.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dictionary.data.room.WordEntity
import com.example.dictionary.databinding.ItemWordBinding


class DashboardAdapter : ListAdapter<WordEntity, DashboardAdapter.Holder>(WordCallback) {

    object WordCallback : DiffUtil.ItemCallback<WordEntity>() {
        override fun areItemsTheSame(oldItem: WordEntity, newItem: WordEntity): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: WordEntity, newItem: WordEntity): Boolean = oldItem.word == newItem.word
    }

    inner class Holder(private val itemDashboardBinding: ItemWordBinding) : RecyclerView.ViewHolder(itemDashboardBinding.root) {

        fun bind() {
            val item = getItem(absoluteAdapterPosition)
//            itemDashboardBinding.textAuthor.text = item.word
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder = Holder(ItemWordBinding.inflate(
        LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: Holder, position: Int) = holder.bind()
}