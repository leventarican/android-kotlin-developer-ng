package com.github.leventarican.room.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.leventarican.room.R
import com.github.leventarican.room.room.ProgrammingLanguage

class ProgrammingLanguageListAdapter : ListAdapter<ProgrammingLanguage, ProgrammingLanguageListAdapter.ProgrammingLanguageViewHolder>(ProgrammingLanguageComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgrammingLanguageViewHolder {
        return ProgrammingLanguageViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ProgrammingLanguageViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.language)
    }

    class ProgrammingLanguageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val programming_languageItemView: TextView = itemView.findViewById(R.id.textView)

        fun bind(text: String?) {
            programming_languageItemView.text = text
        }

        companion object {
            fun create(parent: ViewGroup): ProgrammingLanguageViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item, parent, false)
                return ProgrammingLanguageViewHolder(view)
            }
        }
    }

    class ProgrammingLanguageComparator : DiffUtil.ItemCallback<ProgrammingLanguage>() {
        override fun areItemsTheSame(oldItem: ProgrammingLanguage, newItem: ProgrammingLanguage): Boolean {
            return oldItem.id === newItem.id
        }

        override fun areContentsTheSame(oldItem: ProgrammingLanguage, newItem: ProgrammingLanguage): Boolean {
            return oldItem.language == newItem.language
        }
    }

}