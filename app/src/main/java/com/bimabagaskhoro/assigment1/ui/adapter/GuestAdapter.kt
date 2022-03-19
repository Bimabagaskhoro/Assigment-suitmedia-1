package com.bimabagaskhoro.assigment1.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bimabagaskhoro.assigment1.R
import com.bimabagaskhoro.assigment1.databinding.ItemsGuestBinding
import com.bimabagaskhoro.assigment1.domain.model.ItemGuest
import com.bumptech.glide.Glide
import java.util.ArrayList

@Suppress("DEPRECATION")
class GuestAdapter : RecyclerView.Adapter<GuestAdapter.ListViewHolder>() {
    private var listData = ArrayList<ItemGuest>()
    var onItemClick: ((ItemGuest) -> Unit)? = null

    fun setData(newListData: List<ItemGuest>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.items_guest, parent, false)
        )

    override fun onBindViewHolder(holder: GuestAdapter.ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount() = listData.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemsGuestBinding.bind(itemView)
        fun bind(data: ItemGuest) {
            binding.apply {
                Glide.with(itemView.context)
                    .load(data.avatar)
                    .into(imgGuest)
                tvFirstName.text = data.firstName
                tvLastName.text = data.lastName
            }
        }
        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}