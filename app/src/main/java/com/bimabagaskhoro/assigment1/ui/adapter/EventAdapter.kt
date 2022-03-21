package com.bimabagaskhoro.assigment1.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bimabagaskhoro.assigment1.R
import com.bimabagaskhoro.assigment1.databinding.ItemsEventBinding
import com.bimabagaskhoro.assigment1.domain.model.ItemEvent
import com.bimabagaskhoro.assigment1.ui.event.EventFragment
import com.bumptech.glide.Glide
import java.util.ArrayList

class EventAdapter : RecyclerView.Adapter<EventAdapter.ListViewHolder>() {
    private var listData = ArrayList<ItemEvent>()
    var onItemClick: ((ItemEvent) -> Unit)? = null

    fun setData(data: List<ItemEvent>?) {
        if (data == null) return
        listData.clear()
        listData.addAll(data)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.items_event, parent, false)
        )

    override fun onBindViewHolder(holder: EventAdapter.ListViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount() = listData.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemsEventBinding.bind(itemView)
        fun bind(data: ItemEvent) {
            binding.apply {
                Glide.with(itemView.context)
                    .load(data.image)
                    .into(imgEvent)
                tvTittle.text = data.name
                tvDate.text = data.date
                itemView.setOnClickListener {
                    onItemClick?.invoke(data)
                }
            }

        }
    }

}