package com.example.dictionary.ui.adapter

import android.annotation.SuppressLint
import android.database.Cursor
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dictionary.data.room.WordEntity
import com.example.dictionary.databinding.ItemWordBinding

class CursorDashboardAdapter : RecyclerView.Adapter<CursorDashboardAdapter.Holder>() {
    private var itemClick: ((WordEntity) -> Unit)? = null

    private var cursor: Cursor? = null
    private var query: String? = null

    @SuppressLint("NotifyDataSetChanged")
    fun submitCursor(cursor: Cursor, query: String? = null) {
        this.cursor = cursor
        this.query = query
        notifyDataSetChanged()
    }

    inner class Holder(private val itemWordBinding: ItemWordBinding) :
        RecyclerView.ViewHolder(itemWordBinding.root) {
        fun bind() {
            cursor?.let { cursor ->
                cursor.moveToPosition(absoluteAdapterPosition)

                var word = cursor.getString(cursor.getColumnIndexOrThrow("en_word"))
                word = word[0] + word.substring(1, word.length).lowercase()


                val data = WordEntity(
                    cursor.getInt(cursor.getColumnIndexOrThrow("id")),
                    cursor.getString(cursor.getColumnIndexOrThrow("en_word")),
                    cursor.getString(cursor.getColumnIndexOrThrow("en_definition")),
                    cursor.getString(cursor.getColumnIndexOrThrow("example")),
                    cursor.getString(cursor.getColumnIndexOrThrow("synonyms")),
                    cursor.getString(cursor.getColumnIndexOrThrow("antonyms")),
                    cursor.getInt(cursor.getColumnIndexOrThrow("repeat_counst"))
                )

                itemWordBinding.apply {
                    wordTv.text = word
                    descriptionTv.text = data.word
                    if (data.repeatCounts > 0) repeatCountTv.text = data.repeatCounts.toString()

                }
                itemWordBinding.root.setOnClickListener {

                    itemClick!!.invoke(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
        Holder(ItemWordBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.bind()
    }

    override fun getItemCount(): Int {
        cursor?.let {
            return it.count
        }
        return 0
    }

    fun setItemClick(block: (WordEntity) -> Unit) {
        itemClick = block
    }

}