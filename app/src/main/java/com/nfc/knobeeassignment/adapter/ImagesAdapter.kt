package com.nfc.knobeeassignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nfc.knobeeassignment.databinding.ItemImageBinding
import com.nfc.knobeeassignment.model.Gallery

class ImagesAdapter(val list:List<Gallery>):RecyclerView.Adapter<ImagesAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: ItemImageBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemImageBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(holder.binding.image.context).load(list[position].filename).into(holder.binding.image)
        if (position==3 && list.size>4){
            val moreImages=list.size-4
            "+$moreImages more images".also { holder.binding.tvMore.text = it }
        }
    }

    override fun getItemCount(): Int {
       return if (list.size<4) list.size else 4
    }
}