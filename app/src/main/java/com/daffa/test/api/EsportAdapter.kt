package com.daffa.test.api

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.daffa.test.databinding.FragmentHomeBinding
import com.daffa.test.databinding.ItemRowNewsBinding

class EsportAdapter(private val esportList: List<EsportsResponseItem>) :
RecyclerView.Adapter<EsportAdapter.MyViewHolder>(){
    class MyViewHolder(val binding: ItemRowNewsBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= MyViewHolder (
        ItemRowNewsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = esportList[position]
        holder.binding.apply {
            tvCategory.text = data.tag
            tvTitle.text = data.title
            tvDate.text = data.time

            Glide.with(imgNews.context).load(data.thumb).into(imgNews)
        }
    }

    override fun getItemCount(): Int = esportList.size
}