package com.drexapp.recyclerviewapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_list.view.*

class AdapterDJ: RecyclerView.Adapter<AdapterDJ.ListViewHolder>() {

    private lateinit var onItemClickListener: OnItemClickListener
    private val listDJ = ArrayList<DJ>()

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    fun setData(itemData: ArrayList<DJ>) {
        listDJ.clear()
        listDJ.addAll(itemData)
        notifyDataSetChanged()
    }

    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(dj: DJ) {
            with(itemView) {
                Glide.with(context).load(dj.image).into(item_list_image)
                item_list_name.text = dj.name
                item_list_genre.text = dj.genre
                itemView.setOnClickListener {
                    onItemClickListener.onItemClicked(listDJ[adapterPosition])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterDJ.ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listDJ.size

    override fun onBindViewHolder(holder: AdapterDJ.ListViewHolder, position: Int) {
        holder.bind(listDJ[position])
    }

    interface OnItemClickListener {
        fun onItemClicked(dj: DJ)
    }
}