package com.viksaa.resources.app.ui.text.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.viksaa.resources.app.Constants.FONTS_LIST
import com.viksaa.resources.app.R
import com.viksaa.resources.app.databinding.ItemDummyTextBinding


class FontsRecyclerViewAdapter : RecyclerView.Adapter<FontsRecyclerViewAdapter.MyViewHolder>() {

    private lateinit var binding: ItemDummyTextBinding

    inner class MyViewHolder(binding: ItemDummyTextBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var cardTitle = binding.cardTitle
        var cardText = binding.cardText
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding =
            ItemDummyTextBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.cardTitle.text =
            String.format(holder.cardTitle.context.getString(R.string.font_text), position + 1)
        holder.cardText.typeface =
            ResourcesCompat.getFont(holder.cardText.context, FONTS_LIST[position])
    }

    override fun getItemCount(): Int {
        return FONTS_LIST.size
    }

}