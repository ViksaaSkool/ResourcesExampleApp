package com.viksaa.resources.app.ui.text.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.viksaa.resources.app.Constants.FONTS_LIST
import com.viksaa.resources.app.R


class FontsRecyclerViewAdapter: RecyclerView.Adapter<FontsRecyclerViewAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var cardTitle = view.findViewById<AppCompatTextView>(R.id.card_title)
        var cardText = view.findViewById<AppCompatTextView>(R.id.card_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_dummy_text, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.cardTitle.text = String.format(holder.cardTitle.context.getString(R.string.font_text), position+1)
        holder.cardText.typeface = ResourcesCompat.getFont(holder.cardText.context, FONTS_LIST[position])
    }

    override fun getItemCount(): Int {
        return FONTS_LIST.size
    }

}