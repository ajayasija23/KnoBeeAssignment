package com.nfc.knobeeassignment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nfc.knobeeassignment.databinding.ItemPostsBinding
import com.nfc.knobeeassignment.model.Gallery


class PostsAdapter(val mContext: Context,val list:List<List<Gallery>>):RecyclerView.Adapter<PostsAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: ItemPostsBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemPostsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.rvPhotos.adapter=ImagesAdapter(list[position])
        val layoutManager=getLayoutManager(list[position])
        holder.binding.rvPhotos.layoutManager=layoutManager
    }

    private fun getLayoutManager(galleries: List<Gallery>): RecyclerView.LayoutManager {
        return when (galleries.size) {
            1 -> {
                LinearLayoutManager(mContext)
            }
            2 -> {
                val layoutManager=GridLayoutManager(mContext,2,GridLayoutManager.VERTICAL,false)
                layoutManager
            }
            else -> {
                val layoutManager=GridLayoutManager(mContext,2,GridLayoutManager.VERTICAL,false)
                layoutManager
            }
        }
    }

    override fun getItemCount(): Int {
       return list.size
    }
}