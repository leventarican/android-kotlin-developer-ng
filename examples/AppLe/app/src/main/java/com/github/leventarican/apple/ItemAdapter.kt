package com.github.leventarican.apple

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Here happens the magic. The glue for logic and android.
 *
 * Remember ProgrammingLang contains string resource id.
 * The Adapter needs to know how to resolve these string resource id's.
 * That's why we add the android context here.
 *
 * We also define the ViewHolder here. RecyclerView deals with ViewHolder.
 * a nested class. contains view for reuse.
 *
 * onCreateViewHolder:
 * called by the layout manager.
 * the layout inflater knows how to inflate a xml to a hierarchy of views.
 * in this case we inflate item xml to parent view group.
 *
 * onBindViewHolder:
 * called by the layout manager.
 * here happens the replacement of a view. the reuse.
 * we also resolve the string resource id to string with usage of context
 */
class ItemAdapter(private val context: Context, private val dataset: List<ProgrammingLang>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text =  context.resources.getString(item.stringResourceId)
    }

    override fun getItemCount() = dataset.size

}